package demo.lon.com.commonlibrary.mvp.logic;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.mvp.presenter.IPresenter;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/23 16:57
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface ILogic<P extends IPresenter,VM extends ViewModel> {

    /**
     * 为了在某些情况下面调用 IPresenter或者 IPresenter子类中的某些方法
     *
     * @return
     */
    void setPresenter(P presenter);

    /**
     * 用于观察从网路中获取到的数据,更新view
     * @param viewModule
     */
    void setViewModule(VM viewModule);

    /**
     * 当Fragment/Fragment销毁的时候,IVIew在onDestory()调用IPresenter中的onDestory()
     * IPresenter在onDestory()调用IModule中的onDestory()
     */
    void onDestory();

}
