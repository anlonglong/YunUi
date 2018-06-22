package demo.lon.com.commonlibrary.mvp.view;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.mvp.presenter.IPresenter;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/23 16:56
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface IView<VM extends ViewModel>{


    void showLoading();

    void hideLoading();

    void showMessage(String msg);

    void showError(String msg);

    VM getViewModule();

}
