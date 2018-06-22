package demo.lon.com.commonlibrary.mvp.presenter;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.view.IView;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/23 16:54
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface IPresenter<V extends IView, L extends ILogic,VM extends ViewModel> {

    /**
     * 在这个方法中可以给VIew注册Presnter
     * @param view
     */
    void attachView(V view);

    V getView();

    void setLogic(L logic);

    L getLogic();

    void setViewModule(VM viewModule);

    boolean isViewAttach();

    void onDestory();
}
