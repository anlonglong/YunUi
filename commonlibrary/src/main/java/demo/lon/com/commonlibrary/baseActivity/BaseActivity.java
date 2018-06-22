package demo.lon.com.commonlibrary.baseActivity;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;
import demo.lon.com.commonlibrary.mvp.view.IView;
import demo.lon.com.commonlibrary.stateLayout.StateLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/19 14:12
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public abstract class BaseActivity<P extends BasePresenter,
                                   VM extends ViewModel, V extends IView<VM>,
                                   L extends ILogic<P,VM>>
        extends LifecycleActivity  {

    private boolean mNeedStatuLayout;
    private StateLayout mStateLayout;
    private Handler mHandler;
    private Unbinder mBind;


    private VM mViewModule;
    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isNeedStatuLayout()) {
            FrameLayout rootView = new FrameLayout(this);
            rootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mStateLayout = new StateLayout(this);
            if (!Objects.equals(0, getContentLayout())) {
                rootView.addView(View.inflate(this, getContentLayout(), null));
                rootView.addView(mStateLayout);
                setContentView(rootView);
            }
        } else {
            setContentView(getContentLayout());
        }
        mBind = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (null == mPresenter) {
            throw new NullPointerException("mPresenter should not be null !!!!!");
        }
        mPresenter.attachView(((V) this));
        mViewModule = createViewModule();
        if (null == mViewModule) {
            throw new NullPointerException("mViewModule should not be null !!!!!");
        }
        mPresenter.setLogic(createLogic());
        mPresenter.setViewModule(mViewModule);
        initView();
        initData();

    }

    protected abstract L createLogic();


    public VM createViewModule() {
        return (VM) ViewModelProviders.of(this).get(ClassUtils.getViewModuleClass(getClass()));
    };

    /**
     * 每个模块的Presenter都不一样,应该交给具体的子类去创建
     *  通过注解,用工厂模式创建.
     *
     * @return 当前模块的P
     */
    public abstract P createPresenter();


//    /**
//     * 父类给你创好了P
//     * @return
//     */
//    public P getPresenter() {
//        return mPresenter;
//    }

    /**
     * 父类给你创好了P,但是这的话父类有点管闲事了
     * @return
     */
    public P getPresenterByRef() {
        return ClassUtils.getPresenter(getClass(),ClassType.PRESENTER);
    }

    public VM getViewModule() {
        return mViewModule;
    }


    /**
     * 这种方式的创建Preenter有两个缺点,1.是父类有点多管闲事了;2.不便于通过Presenter构造函数传递参数
     *
     * @return
     */
//    private P createPresenter() {
//        return  ((P)ClassUtils.getPresenter(getClass(),ClassType.PRESENTER));
//    }
    public Handler getHandler() {
        if (null == mHandler) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    handlerMessage(msg);
                }
            };
        }
        return mHandler;
    }

    protected void handlerMessage(Message msg) {

    }


//    public void showLoading() {
//        mStateLayout.showLoading();
//    }

    public void showEmpty() {
        mStateLayout.showEmpty();
    }

    public void showaError() {
        mStateLayout.showError();
    }


//    public VM getViewModule() {
//        VM vm = (VM) ViewModelProviders.of(this).get(ClassUtils.getViewModuleClass(getClass()));
//        P presenter = ((P)ClassUtils.getPresenter(getClass(),ClassType.PRESENTER));
//        VM viewModule = (VM) ClassUtils.getViewModule(getClass(), ClassType.VIEW_MODULE);
//        return vm;
//    }

//    public void setViewModule(VM viewModule) {
//        VM viewMo = (VM) ClassUtils.getViewModule(getClass(), ClassType.VIEW_MODULE);//这样创建ViewModule没法在构造中传参
//        mViewModule = viewModule;
//    }


    public void showLoading() {
        mStateLayout.showLoading();
    }


    public void hideLoading() {
        mStateLayout.hideAllView();
    }


    public void showMessage(String msg) {

    }

    protected abstract void initData();

    protected abstract void initView();

    public abstract boolean isNeedStatuLayout();

    public abstract int getContentLayout();


    @Override
    protected void onDestroy() {
        if (null != mBind) {
            mBind.unbind();
        }

        if (null != mPresenter) {
            mPresenter.onDestory();
        }
        super.onDestroy();
    }

}
