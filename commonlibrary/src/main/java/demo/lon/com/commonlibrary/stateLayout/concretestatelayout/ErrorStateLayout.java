package demo.lon.com.commonlibrary.stateLayout.concretestatelayout;

import android.view.View;
import android.widget.LinearLayout;

import demo.lon.com.commonlibrary.stateLayout.LayoutStateListener;
import demo.lon.com.commonlibrary.stateLayout.LayoutStateValue;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:14
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class ErrorStateLayout implements LayoutStateListener {
    @Override
    public void layoutStateChanged(LinearLayout loadingView, LinearLayout emptyView, LinearLayout errorView) {
        if (errorView.getVisibility() == View.GONE) {

            errorView.setVisibility(View.VISIBLE);
        }
        if (loadingView.getVisibility() == View.VISIBLE) {

            loadingView.setVisibility(View.GONE);
        }

        if (emptyView.getVisibility() == View.VISIBLE) {

            emptyView.setVisibility(View.GONE);
        }
    }

    @Override
    public LayoutStateValue.State getState() {
        return LayoutStateValue.State.ERROR;
    }
}
