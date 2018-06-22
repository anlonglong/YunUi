package demo.lon.com.commonlibrary.stateLayout.concretestatelayout;

import android.view.View;
import android.widget.LinearLayout;

import demo.lon.com.commonlibrary.stateLayout.LayoutStateListener;
import demo.lon.com.commonlibrary.stateLayout.LayoutStateValue;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:13
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class LoadingStateLayout implements LayoutStateListener {

    @Override
    public void layoutStateChanged(LinearLayout loadingView, LinearLayout emptyView, LinearLayout errorView) {
        if (loadingView.getVisibility() == View.GONE) {

            loadingView.setVisibility(View.VISIBLE);
        }
         if (emptyView.getVisibility() == View.VISIBLE) {

             emptyView.setVisibility(View.GONE);
         }

        if (errorView.getVisibility() == View.VISIBLE) {

            errorView.setVisibility(View.GONE);
        }
    }

    @Override
    public LayoutStateValue.State getState() {
        return LayoutStateValue.State.LOADING;
    }
}
