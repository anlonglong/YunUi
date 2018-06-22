package an.along.com.yunyue.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import an.along.com.yunyue.R;

/**
 * Created by：anlonglong
 * <p>
 * on 2018/1/10 13:36
 * <p>
 * Email: anlonglong0721@gmail.com
 */

public class DiscoveryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discovery_layout, null);
        return view;
    }

    public static DiscoveryFragment newInstance() {

        Bundle args = new Bundle();

        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
