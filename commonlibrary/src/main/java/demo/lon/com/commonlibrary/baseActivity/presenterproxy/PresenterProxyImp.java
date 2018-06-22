package demo.lon.com.commonlibrary.baseActivity.presenterproxy;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.baseActivity.PFactory.PresenterFactory;
import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;
import demo.lon.com.commonlibrary.mvp.view.IView;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 16:05
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class PresenterProxyImp<P extends BasePresenter> implements PresenterProxy<P> {



    private PresenterFactory<P> mFactory;

    @Override
    public void setPresenterFactory(PresenterFactory< P> factory) {
        this.mFactory = factory;
    }

    @Override
    public PresenterFactory< P> getFactory() {
        return mFactory;
    }

    @Override
    public P getPresenter() {
        return mFactory.createPresenter();
    }
}
