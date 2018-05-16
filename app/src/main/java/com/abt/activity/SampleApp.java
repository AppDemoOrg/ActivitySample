package com.abt.activity;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @描述： @SampleApp
 * @作者： @黄卫旗
 * @创建时间： @2018/5/16
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
