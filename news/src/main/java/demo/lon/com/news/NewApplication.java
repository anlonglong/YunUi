package demo.lon.com.news;

import android.app.Application;
import android.content.Context;

import java.util.List;

import demo.lon.com.commonlibrary.application.IAppLife;
import demo.lon.com.commonlibrary.application.IModuleConfig;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 15:35
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class NewApplication implements IAppLife,IModuleConfig {

    private static final String tag = NewApplication.class.getSimpleName();
    private static Context sContext;
    @Override
    public void attachBaseContext(Context context) {

        System.out.println(tag+"context = [" + context + "]");
        sContext = context;
    }

    @Override
    public void onCreate(Application application) {
        System.out.println(tag+"application = [" + application + "]");
    }

    @Override
    public void onTerminate(Application application) {
        System.out.println(tag+"application = [" + application + "]");
    }

    @Override
    public void injectApplife(Context context, List<IAppLife> iAppLifes) {
             iAppLifes.add(this);
        System.out.println(tag+"context = [" + context + "], iAppLifes = [" + iAppLifes + "]");
    }

    @Override
    public void injectActivityLifecycleCallbacks(Context context, List<Application.ActivityLifecycleCallbacks> lifecycleCallbacks) {
        System.out.println(tag+"context = [" + context + "], lifecycleCallbacks = [" + lifecycleCallbacks + "]");
    }

    public static Context getContext() {
        return sContext;
    }
}
