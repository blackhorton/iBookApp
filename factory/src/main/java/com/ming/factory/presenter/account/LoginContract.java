package com.ming.factory.presenter.account;

import com.ming.factory.presenter.BaseContract;

/**
 * @author Hortons
 * on 2020/3/18
 */


public interface LoginContract {

    interface View extends BaseContract.View<Presenter> {
        // 登录成功
        void loginSuccess();
    }


    interface Presenter extends BaseContract.Presenter {
        // 发起一个登录
        void login(String phone, String password);
    }
}
