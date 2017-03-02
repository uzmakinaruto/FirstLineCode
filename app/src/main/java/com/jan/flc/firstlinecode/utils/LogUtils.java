package com.jan.flc.firstlinecode.utils;

import android.util.Log;

/**
 * Created by huangje on 17-3-2.
 */

public class LogUtils {

    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARN = 3;
    public static final int LEVEL_ERR = 4;
    public static final int LEVEL_NOTHING = 5;

    public static int currentLevel = LEVEL_VERBOSE;

    public static void v(String tag, String msg) {
        if (currentLevel <= LEVEL_VERBOSE)
            Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (currentLevel <= LEVEL_DEBUG)
            Log.v(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (currentLevel <= LEVEL_INFO)
            Log.v(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (currentLevel <= LEVEL_WARN)
            Log.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (currentLevel <= LEVEL_ERR)
            Log.v(tag, msg);
    }
}
