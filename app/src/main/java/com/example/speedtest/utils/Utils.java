package com.example.speedtest.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {
    private Utils() {
        throw new IllegalStateException("Utility class");
    }


    public static void EnableNotification(Context context, String key,
                                          boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static boolean isEnabledNotification(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, true);
    }
}
