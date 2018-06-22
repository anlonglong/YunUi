package demo.lon.com.commonlibrary.dagger.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import demo.lon.com.commonlibrary.application.BaseApplication;
import demo.lon.com.commonlibrary.dagger.scope.SingletonApplication;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/2/2 10:36
 * <p>
 * Email: anlonglong0721@gmail.com
 */

@Module
public class AppModule {


    public AppModule() {

    }

    @SingletonApplication
    @Provides
    public Application getBaseApplication() {
        return BaseApplication.getApplication();
    }
}
