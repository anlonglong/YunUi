package demo.lon.com.commonlibrary.stateLayout;

import android.widget.LinearLayout;

import java.util.Objects;

import demo.lon.com.commonlibrary.stateLayout.concretestatelayout.LoadingStateLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:11
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class StateLayoutControl {

    private LayoutStateListener mListener = new LoadingStateLayout();

    private LinearLayout loadingView , emptyView,  errorView;
    public StateLayoutControl() {

    }

    public void setStaterListener(LayoutStateListener listener) {
        mListener = listener;
    }

    public void setEmptyView(LinearLayout emptyView) {
        this.emptyView = emptyView;
    }

    public void setLoadingView(LinearLayout loadingView) {
        this.loadingView = loadingView;
    }

    public void setErrorView(LinearLayout errorView) {
        this.errorView = errorView;
    }

    public void changdeLayoutState() {
        Objects.requireNonNull(loadingView);
        Objects.requireNonNull(emptyView);
        Objects.requireNonNull(errorView);
        mListener.layoutStateChanged(loadingView, emptyView, errorView);
    }

    public LayoutStateValue.State getLayoutState(){
        return mListener.getState();
    }
}
