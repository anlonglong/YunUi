package demo.lon.com.commonlibrary.baseActivity.PFactory;

import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 14:10
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface PresenterFactory<P extends BasePresenter> {
    /**
     * 创建具体presenter的工厂
     * @return 要创建的Presenter.
     */
    P createPresenter();

}
