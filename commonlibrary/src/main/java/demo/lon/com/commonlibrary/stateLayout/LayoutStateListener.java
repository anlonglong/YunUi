package demo.lon.com.commonlibrary.stateLayout;

import android.widget.LinearLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 16:11
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public interface LayoutStateListener {
    void layoutStateChanged(LinearLayout loadingView, LinearLayout emptyView, LinearLayout errorView);
    LayoutStateValue.State getState();
//    void showLoading(LinearLayout loadingView);
//    void showEmpty(LinearLayout emptyView);
//    void showError(LinearLayout errorView);
//    void hide(LinearLayout... loadingView);

}
