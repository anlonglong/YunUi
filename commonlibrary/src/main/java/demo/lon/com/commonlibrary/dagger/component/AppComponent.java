package demo.lon.com.commonlibrary.dagger.component;

import android.app.Application;

import dagger.Component;
import demo.lon.com.commonlibrary.dagger.module.AppModule;
import demo.lon.com.commonlibrary.dagger.scope.SingletonApplication;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/2/1 11:50
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@SingletonApplication
@Component(modules = AppModule.class)
public interface AppComponent {

    Application getApplication();

}
