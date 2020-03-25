package com.ming.factory.presenter.contract;

import com.ming.factory.data.DataSource;
import com.ming.factory.model.card.UserCard;
import com.ming.factory.presenter.BasePresenter;

/**
 * @author Hortons
 * on 2020/3/23
 */


public class FollowPresenter extends BasePresenter<FollowContract.View>
        implements FollowContract.Presenter, DataSource.Callback<UserCard> {

    public FollowPresenter(FollowContract.View view) {
        super(view);
    }

    @Override
    public void follow(String id) {
        start();

    }


    @Override
    public void onDataLoaded(UserCard userCard) {

    }

    @Override
    public void onDataNotAvailable(int strRes) {

    }


}
