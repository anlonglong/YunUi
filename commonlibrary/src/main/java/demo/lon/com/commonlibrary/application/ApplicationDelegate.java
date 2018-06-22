package demo.lon.com.commonlibrary.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 11:28
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class ApplicationDelegate implements IAppLife {


    List<IModuleConfig> mIModuleConfigs;
    List<IAppLife> mIAppLifes;
    List<Application.ActivityLifecycleCallbacks> mLifecycleCallbacks;

    public ApplicationDelegate() {
        mIAppLifes = new ArrayList<>();
        mLifecycleCallbacks = new ArrayList<>();
    }

    @SuppressLint("NewApi")
    @Override
    public void attachBaseContext(Context context) {
        mIAppLifes.stream()
                .filter(iAppLife -> null != iAppLife)
                .forEach(iAppLife -> iAppLife.attachBaseContext(context));


        MainfestParser mainfestParser = new MainfestParser();
        mIModuleConfigs = mainfestParser.parse(context);
        mIModuleConfigs.stream()
                .filter(iModuleConfig -> null != iModuleConfig)
                .forEach(iModuleConfig -> {
                    iModuleConfig.injectActivityLifecycleCallbacks(context, mLifecycleCallbacks);
                    iModuleConfig.injectApplife(context, mIAppLifes);
                });
    }

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Application application) {
        mIAppLifes.stream()
                .filter(iAppLife -> null != iAppLife)
                .forEach(iAppLife -> iAppLife.onCreate(application));

        mLifecycleCallbacks.stream()
                .forEach(lifecycleCallbacks -> {
                    application.registerActivityLifecycleCallbacks(lifecycleCallbacks);
                });
    }

    @SuppressLint("NewApi")
    @Override
    public void onTerminate(Application application) {
        mLifecycleCallbacks.stream()
                .forEach(lifecycleCallbacks -> {
                    application.unregisterActivityLifecycleCallbacks(lifecycleCallbacks);
                });

        mIAppLifes.stream()
                .filter((iAppLife -> null != iAppLife))
                .forEach(iAppLife -> iAppLife.onTerminate(application));

    }

}
