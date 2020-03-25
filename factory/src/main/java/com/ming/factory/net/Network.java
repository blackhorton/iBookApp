package com.ming.factory.net;

import android.text.TextUtils;

import com.ming.common.Common;
import com.ming.factory.Factory;
import com.ming.factory.persistence.Account;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Hortons
 * on 2020/3/18
 */


public class Network {

    private static Network instance;

    private Retrofit retrofit;

    static {
        instance = new Network();
    }

    private Network() {}

    /**
     * 构建一个Retrofit
     * @return
     */
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null) {
            return instance.retrofit;
        }

        //得到一个OK Client
        OkHttpClient client = new OkHttpClient.Builder()
                //给所以的请求添加一个拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //拿到我们的请求
                        Request original = chain.request();
                        //重新进行build
                        Request.Builder builder = original.newBuilder();
                        if (TextUtils.isEmpty(Account.getToken())) {
                            //注入一个token
                            builder.addHeader("token", Account.getPushId());
                        }
                        builder.addHeader("Content-Type", "application/json");
                        Request newRequest = builder.build();

                        //返回
                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit.Builder builder = new Retrofit.Builder();

        //设置电脑链接
        instance.retrofit = builder.baseUrl(Common.Constance.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(Factory.getGson()))
                .build();

        return instance.retrofit;
    }

    /**
     * 返回一个请求代理
     *
     * @return RemoteService
     */
    public static RemoteService remote() {
        return Network.getRetrofit().create(RemoteService.class);
    }

}
