package demo.lon.com.news;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import demo.lon.com.commonlibrary.application.BaseApplication;
import demo.lon.com.commonlibrary.stateLayout.StateLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/31 17:21
 * <p>
 * Email: anlonglong0721@gmail.com
 */

@Module
public class Moudle {

    private Context mContext;

    public Moudle(Context context) {
        mContext = context;
    }

    @Provides
    public NewLogic providerLogic() {
        return new NewLogic();
    }

    @Provides
    public NewsViewModule providerViewModule() {
        return new NewsViewModule();
    }

    @Provides
    public Context providerApp() {
        return BaseApplication.getApplication();
    }


//    @Provides
//    public StateLayout providerstate_1() {
//        return new StateLayout(providerApp());
//    }
//
//
//    @Provides
//    public StateLayout providerstate_2(Context context) {
//        return new StateLayout(context);
//    }
    @Provides
    public StateLayout providerstate() {
        //构造StateLayout所需要的参数context的提供方式又两种
        //1.在当前类的构造中传进来
        //new StateLayout(mContext)
        //2.写一个用provides修饰的方法提供
//        @Provides
//        public Context providerApp() {
//            return BaseApplication.getApplication();
//        }
        //3.在该方法的形参上面提供context,但是上面的方法还是要提供必要的依赖.
//        @Provides
//        public StateLayout providerstate(Context ctx) {
//            return new StateLayout(ctx);
//        }
        return new StateLayout(mContext);
    }

}
