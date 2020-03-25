package com.ming.factory.data.user;

import com.ming.factory.model.card.UserCard;

/**
 * @author Hortons
 * on 2020/3/17
 */


public interface UserCenter {

    /**
     * 分发处理一堆用户卡片的信息，并更新到数据库
     * @param cards
     */
    void dispatch(UserCard... cards);
}
