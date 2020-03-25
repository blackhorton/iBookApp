package com.ming.ibookapp.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;

/**
 * 解决对Fragment的调度与重用问题
 * 达到最优的Fragment切换
 *
 * @author Hortons
 * on 2020/3/22
 */


public class NavHelper<T> {

    /**
     * 所有Tab的集合
     */
    private final SparseArray<Tab<T>> tabs = new SparseArray<>();

    /**
     * 用于初始化的必须参数
     */
    private final Context context;
    private final int containerId;
    private final FragmentManager fragmentManager;
    private final OnTabChangedListener<T> listener;

    /**
     * 当前的一个选中的Tab
     */
    private Tab<T> currentTab;

    public NavHelper(Context context, int containerId, FragmentManager fragmentManager, OnTabChangedListener<T> listener) {
        this.context = context;
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
        this.listener = listener;
    }

    /**
     * 添加Tab
     *
     * @param menuId Tab对应的菜单Id
     * @param tab    Tab
     * @return
     */
    public NavHelper<T> add(int menuId, Tab<T> tab) {
        tabs.put(menuId, tab);
        return this;
    }

    /**
     * 获取当前显示的Tab
     *
     * @return
     */
    public Tab<T> getCurrentTab() {
        return currentTab;
    }

    /**
     * 执行点击菜单的操作
     *
     * @param menuId 菜单的Id
     * @return 是否能够处理这个点击
     */
    public boolean performClickMenu(int menuId) {
        //集合中寻找点击的菜单对应的Tab
        //如果有则进行处理
        Tab<T> tab = tabs.get(menuId);
        if (tab != null) {
            doSelect(tab);
            return true;
        }
        return false;
    }

    /**
     * 进行真实的Tab选择操作
     *
     * @param tab
     */
    private void doSelect(Tab<T> tab) {
        Tab<T> oldTab = null;
        if (currentTab != null) {
            oldTab = currentTab;
            if (oldTab == tab) {
                //如果说当前的Tab就是点击的Tab，那么我们不做操作
                notifyTabReselect(tab);
                return;
            }
        }
        //赋值并调用切换方法
        currentTab = tab;
        doTabChanged(currentTab, oldTab);
    }


    /**
     * 进行Fragment的真实的调度操作
     *
     * @param newTab
     * @param oldTab
     */
    private void doTabChanged(Tab<T> newTab, Tab<T> oldTab) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (oldTab != null) {
            if (oldTab.fragment != null) {
                fragmentTransaction.remove(oldTab.fragment);
            }
        }

        if (newTab != null) {
            if (newTab.fragment != null) {
                //首次创建
                Fragment fragment = Fragment.instantiate(context, newTab.clx.getName(), null);
                //缓存起来
                newTab.fragment = fragment;
                //提交到FragmentManager
                fragmentTransaction.add(containerId, fragment, newTab.clx.getName());
            } else {
                //从FragmentManager的缓存控件中重新加载到界面中
                fragmentTransaction.attach(newTab.fragment);
            }
        }
        //提交事务
        fragmentTransaction.commit();
        //通知回调
        notifyTabSelect(newTab, oldTab);
    }

    /**
     * 回调我们的监听器
     *
     * @param newTab 新的Tab<T>
     * @param oldTab 旧的Tab<T>
     */
    private void notifyTabSelect(Tab<T> newTab, Tab<T> oldTab) {
        if (listener != null) {
            listener.onTabChanged(newTab, oldTab);
        }
    }

    private void notifyTabReselect(Tab<T> tab) {
        // TODO 二次点击Tab所做的操作
    }

    public interface OnTabChangedListener<T> {
        /**
         * Tab改变触发
         *
         * @param newTab
         * @param oldTab
         */
        void onTabChanged(Tab<T> newTab, Tab<T> oldTab);
    }

    public static class Tab<T> {

        /**
         * Fragment对应的Class信息
         */
        public Class<?> clx;

        /**
         * 额外的字段，用户自己设定需要使用
         */
        public T extra;

        /**
         * 内部缓存的对应的Fragment
         * Package权限，外部无法使用
         */
        Fragment fragment;


        public Tab(Class<?> clx, T extra) {
            this.clx = clx;
            this.extra = extra;
        }
    }
}
