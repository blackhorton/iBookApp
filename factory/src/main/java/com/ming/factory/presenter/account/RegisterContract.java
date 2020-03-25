package com.ming.factory.presenter.account;

import com.ming.factory.presenter.BaseContract;

/**
 * @author Hortons
 * on 2020/3/21
 */


public interface RegisterContract {

    interface View extends BaseContract.View<Presenter> {
        /**
         * 注册成功
         */
        void registerSuccess();
    }

    interface Presenter extends BaseContract.Presenter {

        /**
         * 发起一个注册
         * @param phone
         * @param name
         * @param password
         */
        void register(String phone, String name, String password);

        /**
         * 检查手机号是否正确
         * @param phone
         * @return
         */
        boolean checkMobile(String phone);

    }
}
