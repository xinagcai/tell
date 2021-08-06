package com.example.tell.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tell.R;
import com.example.tell.adapter.MyPagerAdapter;
import com.example.tell.entity.TabEntity;
import com.example.tell.fragment.EmailFragment;
import com.example.tell.fragment.HomeFragment;
import com.example.tell.fragment.MyFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class HomeAcitivity extends BaseActivity {
    private CommonTabLayout commonTabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"首页", "信箱", "我的"};
    private int[] iconUnselected = {
            R.mipmap.home, R.mipmap.email, R.mipmap.my
    };
    private int[] iconSelected = {
            R.mipmap.home1, R.mipmap.email1, R.mipmap.my1
    };
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragment = new ArrayList<>();

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viwpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }

    @Override
    protected void initDate() {
        mFragment.add(HomeFragment.newInstance());
        mFragment.add(EmailFragment.newInstance());
        mFragment.add(MyFragment.newInstance());
        for (int i = 0; i < iconSelected.length; i++) {
            mTabEntities.add(new TabEntity(iconSelected[i], iconUnselected[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), titles, mFragment));
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), titles, mFragment));
    }

    @Override
    protected int initLayout() {
        return R.layout.home_acitivity;
    }
}