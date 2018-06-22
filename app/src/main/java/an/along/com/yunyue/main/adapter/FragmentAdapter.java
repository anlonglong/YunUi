package an.along.com.yunyue.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import an.along.com.yunyue.discovery.DiscoveryFragment;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/10 13:56
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DiscoveryFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
