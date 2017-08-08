package com.tech.kevin.imitatejdreaderdemo;

import android.util.Log;


/**
 * <p>
 * Created by <b><a href="http://blog.csdn.net/student9128">Kevin</ a></b> on 2017/2/16.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */

public class LogK {
    /**
     * set IS_DEBUG false when release to close log.
     */
//    private static boolean IS_DEBUG = true;
    private static boolean IS_DEBUG = BuildConfig.DEBUG;
//    private static boolean IS_DEBUG = false;

    public static void i(String tag, String message) {
        if (IS_DEBUG) {
            Log.i(tag + "-->:", message);
        }
    }

    public static void e(String tag, String message) {
        if (IS_DEBUG) {
            Log.e(tag + "-->", message);
        }
    }

    public static void w(String tag, String message) {
        if (IS_DEBUG) {
            Log.w(tag + "-->:", message);
        }
    }

    public static void v(String tag, String message) {
        if (IS_DEBUG) {
            Log.v(tag + "-->:", message);
        }
    }

    public static void d(String tag, String message) {
        if (IS_DEBUG) {
            Log.d(tag + "-->:", message);
        }
    }

}
