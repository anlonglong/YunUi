package demo.lon.com.commonlibrary.application;

import android.app.Application;
import android.content.Context;

import java.util.List;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 10:19
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface IModuleConfig {

    void injectApplife(Context context,List<IAppLife> iAppLifes);

    void injectActivityLifecycleCallbacks(Context context, List<Application.ActivityLifecycleCallbacks> lifecycleCallbacks);

}
