package com.ming.ibookapp;

import android.app.Application;

import com.igexin.sdk.PushManager;
import com.ming.common.app.MyApplication;
import com.ming.factory.Factory;

/**
 * @author Hortons
 * on 2020/3/16
 */


public class App extends MyApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        // 调用Factory进行初始化
        Factory.setup();
        // 推送进行初始化
        PushManager.getInstance().initialize(this, null);
    }
}
