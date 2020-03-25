package com.ming.factory.presenter;

/**
 * @author Hortons
 * on 2020/3/18
 */


public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    private T mView;

    public BasePresenter(T view) {
        setView(view);
    }

    /**
     * 给子类使用的获取View的操作
     * 不允许复写
     *
     * @return
     */
    protected final T getView() {
        return mView;
    }

    /**
     * 设置一个View，子类可以复写
     *
     * @param view
     */
    @SuppressWarnings("unchecked")
    protected void setView(T view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        //开始的时候进行Loading调用
        T view= mView;
        if (view != null) {
            view.showLoading();;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void destroy() {
        T view = mView;
        mView = null;
        if (view != null) {
            //把Presenter设置为NULL
            view.setPresenter(null);
        }
    }
}
