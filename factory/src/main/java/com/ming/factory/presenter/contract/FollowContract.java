package com.ming.factory.presenter.contract;

import com.ming.factory.model.card.UserCard;
import com.ming.factory.presenter.BaseContract;

/**
 * 关注的接口定义
 *
 * @author Hortons
 * on 2020/3/23
 */


public interface FollowContract {

    /**
     * 任务调度者
     */
    interface Presenter extends BaseContract.Presenter {
        /**
         * 关注一个人
         * @param id
         */
        void follow(String id);
    }

    interface View extends BaseContract.View<Presenter> {
        /**
         * 成功的情况下返回一个用户的信息
         * @param userCard
         */
        void onFollowSucceed(UserCard userCard);
    }
}
