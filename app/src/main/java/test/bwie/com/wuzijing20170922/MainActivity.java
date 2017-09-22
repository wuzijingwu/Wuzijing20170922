package test.bwie.com.wuzijing20170922;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import test.bwie.com.wuzijing20170922.adapter.FragmentAdapter;
import test.bwie.com.wuzijing20170922.fragment.Fragment2;
import test.bwie.com.wuzijing20170922.fragment.Fragment3;
import test.bwie.com.wuzijing20170922.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private ViewPager viewpager;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private RadioGroup group;
    private MyFragment f1;
    private Fragment2 f2;
    private Fragment3 f3;
    private ArrayList<Fragment> fragmentLists;
    private FragmentManager fragmentManager;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (RadioButton) findViewById(R.id.button1);
        group = (RadioGroup) findViewById(R.id.group);
        button2 = (RadioButton) findViewById(R.id.button2);
        button3 = (RadioButton) findViewById(R.id.button3);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        group.setOnCheckedChangeListener(this);
        f1 = new MyFragment();
        f2 = new Fragment2();
        f3 = new Fragment3();
        fragmentLists = new ArrayList<Fragment>();
        fragmentLists.add(f1);
        fragmentLists.add(f2);
        fragmentLists.add(f3);

        fragmentManager = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager, fragmentLists);
        viewpager.setAdapter(fragmentAdapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        group.check(R.id.button1);
                        break;
                    case 1:
                        group.check(R.id.button2);
                        break;
                    case 2:
                        group.check(R.id.button3);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.button1:
                //显示第一个Fragment并关闭动画效果
                viewpager.setCurrentItem(0, false);
                break;
            case R.id.button2:
                viewpager.setCurrentItem(1, false);
                break;
            case R.id.button3:
                viewpager.setCurrentItem(2, false);
                break;
        }

    }
}
