package demo.lon.com.commonlibrary.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Arrays;
import java.util.Objects;

import demo.lon.com.commonlibrary.BuildConfig;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/19 09:36
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class CommonLog {

    private static boolean mDebug = BuildConfig.DEBUG;

    private static String mTag = CommonLog.class.getSimpleName();

    public static void enableDebug(boolean debug) {
        mDebug = debug;
    }

    private CommonLog() {

    }

    public static void debug(boolean isEnable) {
        debug(mTag, isEnable);
    }

    public static void debug(String tag, boolean isEnable) {
        mTag = tag;
        mDebug = isEnable;
    }


    public static void v(String tag, String msg) {
        if (mDebug) {
            Log.v(tag, msg);
        }
    }

    public static void v(String msg) {
        v(mTag, msg);
    }

    public static void d(String tag, String msg) {
        if (mDebug) {
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        Log.d(mTag, msg);
    }

    public static void i(String tag, String msg) {
        if (mDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(String msg) {
        Log.i(mTag, msg);
    }

    public static void w(String msg) {
        w(mTag, msg);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(String tag, String msg, Throwable throwable) {
        if (mDebug) {
            Log.w(tag, msg, throwable);
        }
    }

    public static void e(String msg) {
        e(mTag, msg);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (mDebug) {
            Log.e(tag, msg, throwable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void e(Throwable e) {
        if (!mDebug) {
            return;
        }
        Objects.requireNonNull(e);
        if (null != e.getCause() && null != e.getStackTrace()) {
            Arrays.stream(e.getStackTrace()).forEach(ste -> e(ste.toString()));
        }
    }

}
