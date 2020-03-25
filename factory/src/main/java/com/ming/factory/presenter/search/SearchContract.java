package com.ming.factory.presenter.search;

import com.ming.factory.model.card.GroupCard;
import com.ming.factory.model.card.UserCard;
import com.ming.factory.presenter.BaseContract;

import java.util.List;

/**
 * @author Hortons
 * on 2020/3/23
 */


public interface SearchContract {

    interface Presenter extends BaseContract.Presenter {
        /**
         * 搜索内容
         * @param content
         */
        void search(String content);
    }

    /**
     * 搜索人界面
     */
    interface UserView extends BaseContract.View<Presenter> {
        /**
         * 搜索用户完成
         * @param userCards
         */
        void onSearchDone(List<UserCard> userCards);
    }

    /**
     * 搜索群的界面
     */
    interface GroupView extends BaseContract.View<Presenter> {
        /**
         * 搜索群完成
         * @param groupCards
         */
        void onSearchDone(List<GroupCard> groupCards);
    }
}
