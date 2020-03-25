package com.ming.factory.model.api.user;

import android.text.TextUtils;

import com.ming.factory.data.helper.DbHelper;
import com.ming.factory.data.user.UserCenter;
import com.ming.factory.model.card.UserCard;
import com.ming.factory.model.db.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Hortons
 * on 2020/3/24
 */


public class UserDispatcher implements UserCenter {

    private static UserCenter instance;

    /**
     * 单线程池，处理卡片一个个的信息进行处理
     */
    private final Executor executor = Executors.newSingleThreadExecutor();

    public static UserCenter getInstance() {
        if (instance == null) {
            synchronized (UserDispatcher.class) {
                if (instance == null) {
                    instance = new UserDispatcher();
                }
            }
        }
        return instance;
    }

    @Override
    public void dispatch(UserCard... cards) {
        if (cards == null || cards.length == 0) {
            return;
        }
        executor.execute(new UserCardHandler(cards));
    }

    /**
     * 线程调度的时候回触发run方法
     */
    private class UserCardHandler implements Runnable {

        private final UserCard[] cards;

        private UserCardHandler(UserCard[] cards) {
            this.cards = cards;
        }


        @Override
        public void run() {
            //单线程调度的时候触发
            List<User> users = new ArrayList<>();
            for (UserCard card : cards) {
                //进行过滤操作
                if (card == null || TextUtils.isEmpty(card.getId())) {
                    continue;
                }
                //添加操作
                users.add(card.build());
            }

            DbHelper.save(User.class, users.toArray(new User[0]));
        }
    }
}
