package demo.lon.com.news;

import android.app.Application;

import com.alibaba.android.arouter.facade.annotation.Route;

import javax.inject.Inject;

import demo.lon.com.commonlibrary.baseActivity.BaseActivity;
import demo.lon.com.commonlibrary.baseActivity.PFactory.CreatePresenter;
import demo.lon.com.commonlibrary.baseActivity.PFactory.PresenterFactoryImp;
import demo.lon.com.commonlibrary.mvp.view.IView;
import demo.lon.com.commonlibrary.stateLayout.StateLayout;
import demo.lon.com.commonlibrary.utils.CommonLog;

@CreatePresenter(NewPresenter.class)
@Route(path = "new/activity")
public class MainActivity extends BaseActivity<NewPresenter,NewsViewModule,IView<NewsViewModule>,NewLogic> implements IView{

    NewPresenter mPresenter;

    @Inject
    NewLogic mLogic;

    @Inject
    NewsViewModule mViewModule;


    @Override
    protected NewLogic createLogic() {
        return new NewLogic();
    }

    @Override
    public NewPresenter createPresenter() {
        if (null == mPresenter) {
            PresenterFactoryImp<NewPresenter> presenterFactoryImp =  PresenterFactoryImp.createFactory(getClass());
            mPresenter = presenterFactoryImp.createPresenter();
            CommonLog.i("重新创建了 new NewPresenter(this)");
        }
        return mPresenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        DaggerMainActivityComponemt.builder().build().inject(this);

        mLogic.setPresenter(mPresenter);
        mViewModule.getLiveData();
    }

    @Override
    public boolean isNeedStatuLayout() {
        return true;
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showaError() {
        super.showaError();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // RxBus.getInstance().unRegisterEvent(this);
    }
}
