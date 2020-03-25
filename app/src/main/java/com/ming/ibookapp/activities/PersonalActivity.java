package com.ming.ibookapp.activities;

import android.content.Context;
import android.content.Intent;

import com.ming.common.app.PresenterToolbarActivity;
import com.ming.factory.presenter.contract.PersonalContract;
import com.ming.ibookapp.R;

/**
 * @author Hortons
 * on 2020/3/25
 */


public class PersonalActivity extends PresenterToolbarActivity<PersonalContract.Presenter> {

    private static final String BOUND_KEY_ID = "BOUND_KEY_ID";
    private String userId;

    public static void show(Context context, String userId) {
        Intent intent = new Intent(context, PersonalActivity.class);
        intent.putExtra(BOUND_KEY_ID, userId);
        context.startActivity(intent);
    }

    @Override
    protected PersonalContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_personal;
    }
}
