package com.bwie.wangbingyang20170922;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bwie.wangbingyang20170922.fragment.Fragment_Host;
import com.bwie.wangbingyang20170922.fragment.Fragment_News;
import com.bwie.wangbingyang20170922.fragment.Fragment_ZL;
import com.bwie.wangbingyang20170922.fragment.Fragment_ZT;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout layout;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager(), titles, fragments));
        layout.setupWithViewPager(viewpager);//将导航栏和viewpager进行关联
        layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());//联动
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        titles.add("最新日报");
        titles.add("专栏");
        titles.add("热门");
        titles.add("主题日报");
        fragments.add(new Fragment_News());
        fragments.add(new Fragment_ZL());
        fragments.add(new Fragment_Host());
        fragments.add(new Fragment_ZT());
    }
    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        layout = (TabLayout) findViewById(R.id.title);
    }

}
