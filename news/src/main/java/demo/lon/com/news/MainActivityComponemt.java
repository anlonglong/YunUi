package demo.lon.com.news;

import android.app.Application;
import android.content.Context;

import dagger.Component;
import demo.lon.com.commonlibrary.stateLayout.StateLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/30 17:39
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@Component(modules = {Moudle.class})
public interface MainActivityComponemt {

    MainActivity inject(MainActivity activity);

    void inject(NewsActivity activity);

    Context getApplication();

    StateLayout getStateLayout();

}
