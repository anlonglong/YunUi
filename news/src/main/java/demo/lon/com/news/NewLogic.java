package demo.lon.com.news;

import javax.inject.Inject;

import demo.lon.com.commonlibrary.mvp.logic.ILogic;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/24 14:06
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class NewLogic implements ILogic<NewPresenter,NewsViewModule> {


   // @Inject
    public NewLogic() {
    }

    @Override
    public void setPresenter(NewPresenter presenter) {

    }

    @Override
    public void setViewModule(NewsViewModule viewModule) {

    }

    @Override
    public void onDestory() {

    }
}
