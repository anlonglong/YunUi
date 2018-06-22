package demo.lon.com.commonlibrary.baseActivity.PFactory;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 15:42
 * <p>
 * Email: anlonglong0721@gmail.com
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BasePresenter> value();
}
