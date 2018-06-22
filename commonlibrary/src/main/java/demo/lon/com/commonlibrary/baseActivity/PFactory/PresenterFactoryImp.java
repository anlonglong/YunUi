package demo.lon.com.commonlibrary.baseActivity.PFactory;

import android.arch.lifecycle.ViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import demo.lon.com.commonlibrary.mvp.logic.ILogic;
import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;
import demo.lon.com.commonlibrary.mvp.view.IView;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/25 15:31
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class PresenterFactoryImp<P extends BasePresenter> implements PresenterFactory<P> {

    private Class<P> mPClass;

    private PresenterFactoryImp(Class<P> PClass) {
        this.mPClass = PClass;
    }


    public static <P extends BasePresenter> PresenterFactoryImp<P> createFactory(Class<?> ViewClazz) {
        CreatePresenter annotation = ViewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (null != annotation) {
            aClass = (Class<P>) annotation.value();
        }

        return aClass == null ? null : new PresenterFactoryImp<>(aClass);
    }


    @Override
    public P createPresenter() {
        P presenter = null;
        try {
            presenter = mPClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            try {
                Constructor<P> constructor = mPClass.getConstructor(IView.class);

            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return presenter;
    }

}
