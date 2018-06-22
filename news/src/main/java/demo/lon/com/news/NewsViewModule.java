package demo.lon.com.news;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 14:04
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class NewsViewModule extends ViewModel {



    @Inject
    public NewsViewModule(){

    }

    private MutableLiveData<String> mLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getLiveData() {
        return mLiveData;
    }

    public void setLiveData(MutableLiveData<String> liveData) {
        mLiveData = liveData;
    }
}
