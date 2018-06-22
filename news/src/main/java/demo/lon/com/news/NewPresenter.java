package demo.lon.com.news;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;
import demo.lon.com.commonlibrary.mvp.view.IView;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 14:05
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class NewPresenter extends BasePresenter<IView<NewsViewModule>,NewLogic,ViewModel> {

    private NewLogic mLogic;


    public NewPresenter() {
    }

    public void doRequest() {
        getView().hideLoading();
    }
}
