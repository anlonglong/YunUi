package demo.lon.com.commonlibrary.mvp.presenter;

import android.arch.lifecycle.ViewModel;

import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.view.IView;
import demo.lon.com.commonlibrary.utils.CommonUtil;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 09:42
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public  class BasePresenter<V extends IView, L extends ILogic,VM extends ViewModel> implements IPresenter<V, L,VM> {


    private V mView;//调用VIew中的某些方法
    private L mLogic; //调用ILogic中的网络请求
    private VM mViewModule; //需要把这个VM传到ILogic中观察网络中的数据变化,以便更新UI

    @Override
    public void attachView(V view) {
        this.mView = CommonUtil.checkNotNull(view);
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void setLogic(L logic) {
        this.mLogic = logic;
    }

    @Override
    public L getLogic() {
        return mLogic;
    }

    @Override
    public void setViewModule(VM viewModule) {
        this.mViewModule = CommonUtil.checkNotNull(viewModule);
        getLogic().setPresenter(this);
        getLogic().setViewModule(viewModule);
    }

    @Override
    public boolean isViewAttach() {
        return mView != null;
    }

    @Override
    public void onDestory() {
        this.mView = null; //因为ILogic依赖于IVIew,如果IView存在的话Ilogic才请求网络,否则不请求
        if (null != getLogic()) {
            getLogic().onDestory();//Ilogic在请求网络的时候,需要判断Iview是否存在,释放Ilogic中的一些资源.
        }
    }

}
