package demo.lon.com.commonlibrary.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/22 10:19
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface IAppLife {

    void attachBaseContext(Context context);

    void onCreate(Application application);

    void onTerminate(Application application);
}
