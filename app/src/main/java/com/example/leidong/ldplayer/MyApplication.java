package com.example.leidong.ldplayer;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by Lei Dong on 2018/6/14.
 */
public class MyApplication extends Application {
    public static final String APP_NAME = "LDPlayer";
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static MyApplication instance;
    /**
     * 是否输出日志信息
     */
    public static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        context = getApplicationContext();
    }

    /**
     * 返回全局Context
     *
     * @return
     */
    public static Context getContext(){
        return context;
    }

    /**
     * 返回MyApplication实例
     *
     * @return
     */
    public static MyApplication getInstance(){
        return instance;
    }
}
