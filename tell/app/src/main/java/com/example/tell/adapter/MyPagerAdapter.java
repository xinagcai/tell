package com.example.tell.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter  extends FragmentPagerAdapter {
    private String[] titles ;
    private ArrayList<Fragment> mFragment = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm,String[] titels,ArrayList<Fragment> fragments){
        super(fm);
        this.titles = titels;
        this.mFragment = fragments;
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }
}

