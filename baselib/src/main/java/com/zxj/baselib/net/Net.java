package com.zxj.baselib.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net {

    public static Retrofit getRetrofit() {
        return getRetrofitBuild().build();
    }

    public static Retrofit.Builder getRetrofitBuild() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getDefaultOkHttpClient());

    }

    private static OkHttpClient getDefaultOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                //其他配置
                .build();
    }
}
