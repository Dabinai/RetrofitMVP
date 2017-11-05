package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabin.www.yilianxi.R;

import java.util.ArrayList;
import java.util.List;

import adapters.FragmentAdapter;

/**
 * Created by Dabin on 2017/11/5.
 */

public class Zixun extends Fragment{
    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<Fragment> fragments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view  = inflater.inflate(R.layout.zixun_item,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        ContentFragment c1 = new ContentFragment();
        ContentFragment c2 = new ContentFragment();
        ContentFragment c3 = new ContentFragment();
        ContentFragment c4 = new ContentFragment();
        fragments.add(c1);
        fragments.add(c2);
        fragments.add(c3);
        fragments.add(c4);
        viewPager.setAdapter(new FragmentAdapter(getActivity().getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
    }
}
