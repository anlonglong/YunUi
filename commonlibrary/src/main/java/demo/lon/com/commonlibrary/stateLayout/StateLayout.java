package demo.lon.com.commonlibrary.stateLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import demo.lon.com.commonlibrary.R;
import demo.lon.com.commonlibrary.stateLayout.concretestatelayout.EmptyStateLayout;
import demo.lon.com.commonlibrary.stateLayout.concretestatelayout.ErrorStateLayout;
import demo.lon.com.commonlibrary.stateLayout.concretestatelayout.HideStateLayout;
import demo.lon.com.commonlibrary.stateLayout.concretestatelayout.LoadingStateLayout;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/18 10:55
 * <p>
 * Email: anlonglong0721@gmail.com
 */

/**
 * 用状态模式去切换三中不同的布局状态,自己维护自己的状态,不用在StateLayout中进行各种判断去切换状态了.
 */
public class StateLayout extends FrameLayout implements View.OnClickListener {

    private StateLayoutControl mStateLayoutCollor;
    private LinearLayout mLoadingView,mEmptyView,mErrorView;
    private onRetreyLinsener mLinsener;

    public StateLayout(Context context) {
        this(context,null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View stateLayout = View.inflate(context, R.layout.empty_layout, this);
        mLoadingView = stateLayout.findViewById(R.id.loading_view);
        mEmptyView = stateLayout.findViewById(R.id.empty_view);
        mErrorView = stateLayout.findViewById(R.id.error_view);
        initState();
        mStateLayoutCollor.changdeLayoutState();
        mLoadingView.setOnClickListener(this);
        mEmptyView.setOnClickListener(this);
        mErrorView.setOnClickListener(this);
    }



    public void showLoading() {
        initState();
        mStateLayoutCollor.setStaterListener(new LoadingStateLayout());
        mStateLayoutCollor.changdeLayoutState();
    }

    public void showEmpty() {
        initState();
        mStateLayoutCollor.setStaterListener(new EmptyStateLayout());
        mStateLayoutCollor.changdeLayoutState();
    }

    public void showError() {
        initState();
        mStateLayoutCollor.setStaterListener(new ErrorStateLayout());
        mStateLayoutCollor.changdeLayoutState();
    }

    public void hideAllView() {
        initState();
        mStateLayoutCollor.setStaterListener(new HideStateLayout());
        mStateLayoutCollor.changdeLayoutState();
    }

    private void initState() {
        if (null == mStateLayoutCollor) {
            mStateLayoutCollor = new StateLayoutControl();
            mStateLayoutCollor.setEmptyView(mEmptyView);
            mStateLayoutCollor.setLoadingView(mLoadingView);
            mStateLayoutCollor.setErrorView(mErrorView);
        }
    }

    public void setLinsener(onRetreyLinsener linsener) {
        mLinsener = linsener;
    }

    public LayoutStateValue.State getCurrentState() {
        return mStateLayoutCollor.getLayoutState();
    }

    @Override
    public void onClick(View v) {
        if (null != mLinsener) {
            mLinsener.onRetrey(((LinearLayout) v));
        }
    }

    public interface onRetreyLinsener {
        void onRetrey(LinearLayout linearLayout);
    }
}
