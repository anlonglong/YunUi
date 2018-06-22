package an.along.com.yunyue.main.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.widget.ImageView;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import an.along.com.yunyue.R;
import an.along.com.yunyue.main.bean.TitleBean;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/10 13:51
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class IndicatorAdapter extends CommonNavigatorAdapter {
    private static SparseArray<TitleBean> sparseArray = new SparseArray<>();
    private ViewPager mViewPager;

    static {
        sparseArray.put(0, new TitleBean(R.drawable.titlebar_discover_selected, R.drawable.titlebar_discover_normal));
        sparseArray.put(1, new TitleBean(R.drawable.titlebar_music_selected, R.drawable.titlebar_music_normal));
        sparseArray.put(2, new TitleBean(R.drawable.titlebar_friends_selected, R.drawable.titlebar_friends_normal));
    }


    public IndicatorAdapter(ViewPager viewPager) {
        mViewPager = viewPager;
    }

    @Override
    public int getCount() {
        return sparseArray.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, int i) {
        CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
        ImageView imageView = new ImageView(context);
        TitleBean titleBean = sparseArray.get(i);
        imageView.setImageResource(i == 0 ? titleBean.getSelectedId() : titleBean.getUnSelectedId());
        commonPagerTitleView.setContentView(imageView);
        commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
            @Override
            public void onSelected(int index, int totalCount) {
                imageView.setImageResource(sparseArray.get(index).getSelectedId());
            }

            @Override
            public void onDeselected(int index, int i1) {
                imageView.setImageResource(sparseArray.get(index).getUnSelectedId());
            }

            @Override
            public void onLeave(int i, int i1, float v, boolean b) {

            }

            @Override
            public void onEnter(int i, int i1, float v, boolean b) {

            }
        });
        commonPagerTitleView.setOnClickListener(v -> mViewPager.setCurrentItem(i));
        return commonPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        return null;
    }
}
