package com.ming.factory.presenter.contract;

import com.ming.factory.model.db.User;
import com.ming.factory.presenter.BaseContract;

/**
 * @author Hortons
 * on 2020/3/23
 */


public interface PersonalContract {

    interface Presenter extends BaseContract.Presenter {
        /**
         * 获取用户信息
         * @return  用户实体类
         */
        User getUserPersonal();
    }

    interface View extends BaseContract.View<Presenter> {
        /**
         * 用户id
         * @return
         */
        String getUserId();

        /**
         * 加载数据完成
         * @param user
         */
        void onLoadDone(User user);

        /**
         * 是否发起聊天
         * @param isAllow
         */
        void allowSayHello(boolean isAllow);

        /**
         * 设置关注状态
         * @param isFollow
         */
        void setFollowStatus(boolean isFollow);
    }
}
