package demo.lon.com.commonlibrary.application;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;

import demo.lon.com.commonlibrary.BuildConfig;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 10:20
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class BaseApplication extends Application {

    private ApplicationDelegate mDelegate;
    private static BaseApplication sApplication;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mDelegate = new ApplicationDelegate();
        mDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        mDelegate.onCreate(this);
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
            ARouter.init(this);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mDelegate.onTerminate(this);
    }



    public static BaseApplication getApplication() {
        return sApplication;
    }
}
