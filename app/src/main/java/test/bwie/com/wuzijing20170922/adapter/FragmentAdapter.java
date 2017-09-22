package test.bwie.com.wuzijing20170922.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dell on 2017/9/22.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }
}
