package an.along.com.yunyue;

import android.app.Application;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/11 14:46
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class YunApplication extends Application {

    private static YunApplication sYunApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sYunApplication = this;
    }

    public static YunApplication getmYunAppliction() {
        return sYunApplication;
    }
}
