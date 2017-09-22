package test.bwie.com.wuzijing20170922.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import test.bwie.com.wuzijing20170922.fragment.MyFragment;

/**
 * Created by dell on 2017/9/22.
 */

public class Myadapter extends FragmentStatePagerAdapter {

    private String[] titles = {"最新日报", "专栏", "热门", "主题日报"};
    private ArrayList<Fragment> mFragment = new ArrayList<>();
    private FragmentManager mFragmentManager;


    public Myadapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    public Myadapter(FragmentManager fm, ArrayList<Fragment> mFragments) {
        super(fm);
        mFragmentManager = fm;
        mFragment = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
