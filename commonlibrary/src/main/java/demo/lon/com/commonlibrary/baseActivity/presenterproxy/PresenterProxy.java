package demo.lon.com.commonlibrary.baseActivity.presenterproxy;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.baseActivity.PFactory.PresenterFactory;
import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;
import demo.lon.com.commonlibrary.mvp.view.IView;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 16:01
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface PresenterProxy<P extends BasePresenter> {

    void setPresenterFactory(PresenterFactory<P> factory);

    PresenterFactory<P> getFactory();

    P getPresenter();

}
