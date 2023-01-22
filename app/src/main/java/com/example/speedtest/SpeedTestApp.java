package com.example.speedtest;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

public class SpeedTestApp extends Application {

    public static final String LOG_PREFIX = "_";

    public static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();

    public static final int MAX_LOG_TAG_LENGTH = 50;

    public static boolean LOGGING_ENABLED = true;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}