package demo.lon.com.commonlibrary.RxBus;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.LinkedHashMap;
import java.util.Map;

import demo.lon.com.commonlibrary.utils.CommonLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import rx.subjects.SerializedSubject;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/26 16:54
 * <p>
 * Email: anlonglong0721@gmail.com
 */

/**
 * 代替EventBus,还有待优化╮(╯▽╰)╭╮（╯＿╰）╭
 */
public class RxBus {

//    private static RxBus instance = null;
//    private Subject mBus;
//    private Map<String ,CompositeDisposable> mDisposableMap;
//    //private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());
//
//    private RxBus(){
//        mBus = PublishSubject.create().toSerialized();
//        mDisposableMap = new LinkedHashMap<>();
//    }
//
//    public static RxBus  getInstance()
//    {
//        if (instance == null) {
//            synchronized (RxBus.class) {
//                if (instance == null) {
//                    instance = new RxBus();
//                }
//            }
//        }
//
//        return instance;
//    }
//
//
//    public void post(Object obj) {
//        mBus.onNext(obj);
//    }
//
//
//    public <T> Observable<T> toObservable() {
//        return mBus;
//    }
//
//
//    public <T> Disposable registerEventWithError(Object object,Class<T> clazz, Consumer<T> action) {
//        Disposable subscribe = mBus.ofType(clazz)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(action);
//        String name = object.getClass().getName();
//        if (mDisposableMap.get(name) != null) {
//            mDisposableMap.get(name).add(subscribe);
//        }else {
//            CompositeDisposable compositeDisposable = new CompositeDisposable();
//            compositeDisposable.add(subscribe);
//            mDisposableMap.put(name,compositeDisposable);
//        }
//        return subscribe;
//    }
//
//    public void unRegisterEvent(Object object) {
//        String name = object.getClass().getName();
//        if (mDisposableMap.get(name) != null) {
//            mDisposableMap.get(name).clear();
//        }else {
//            CommonLog.i("未进行订阅:>>> "+name);
//        }
//    }
private final FlowableProcessor<Object> mBus;

    private RxBus() {
        mBus = PublishProcessor.create().toSerialized();
    }

    private static class Holder {
        private static RxBus instance = new RxBus();
    }

    public static RxBus getInstance() {
        return Holder.instance;
    }

    public void post(@NonNull Object obj) {
        mBus.onNext(obj);
    }

    public <T> Flowable<T> register(Class<T> clz) {
        return mBus.ofType(clz);
    }

    public Flowable<Object> register() {
        return mBus;
    }

    public void unregisterAll() {
        //会将所有由mBus生成的Flowable都置completed状态后续的所有消息都收不到了
        mBus.onComplete();
    }

    public boolean hasSubscribers() {
        return mBus.hasSubscribers();
    }
}
