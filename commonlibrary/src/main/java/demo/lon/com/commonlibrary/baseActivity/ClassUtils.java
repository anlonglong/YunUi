package demo.lon.com.commonlibrary.baseActivity;

import android.arch.lifecycle.ViewModel;
import android.util.Pair;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import demo.lon.com.commonlibrary.mvp.presenter.BasePresenter;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 15:11
 * <p>
 * Email: anlonglong0721@gmail.com
 */

/**
 * 提供一些baseActivity中需要的依赖
 */
 class ClassUtils {


    static <M extends ViewModel> M getViewModule(Class clazz,@ClassType int type) {
        M module = null;
        Class aClass = getActualyType(clazz, type);
        return getViewModuleINstance(aClass);
    }

    static <P extends BasePresenter> P getPresenter(Class clazz,@ClassType int type) {
        P module = null;
        Class aClass = getActualyType(clazz, type);
        return getPresenterINstance(aClass);
    }



    static Class getViewModuleClass(Class cls){
        return getActualyType(cls, ClassType.VIEW_MODULE);
    }

    static Class getPresenterClass(Class cls){
        return getActualyType(cls, ClassType.PRESENTER);
    }

    private static  <M extends ViewModel> M getViewModuleINstance(Class clazz) {
        M module = null;
        if (null == clazz) return module;
        try {
            module= (M) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return module;
    }

    private static  <P extends BasePresenter> P getPresenterINstance(Class clazz) {
        P preenter = null;
        if (null == clazz) return preenter;
        try {
            preenter= (P) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return preenter;
    }

    private static Class getActualyType(Class clazz, @ClassType int type) {
        Class cls = null;
        Type types = clazz.getGenericSuperclass();
        if (null != types &&types instanceof ParameterizedType){
            Type[] actualType = ((ParameterizedType) types).getActualTypeArguments();
            if (actualType != null && actualType.length >1 && type < actualType.length) {
                cls = (Class) actualType[type];//P的实际类型
            }
        }
        return cls;
    }


    @Deprecated
     static Pair<Class,Class> getClases(Class clazz) {
        Pair pair = null;
        Class cls = clazz;
        Type types = cls.getGenericSuperclass();
        if (null != types &&types instanceof ParameterizedType){
            Type[] actualType = ((ParameterizedType) types).getActualTypeArguments();
            if (actualType != null && actualType.length >1) {
                Class fClass = (Class) actualType[0];//P的实际类型
                Class sClass = (Class) actualType[1];//VM的实际类型
                pair = new Pair<Class,Class>(fClass, sClass);
            }
        }
        return pair;
    }
}
