package com.example.tell.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import com.example.tell.R;
import com.example.tell.activity.SetActivity;
import com.example.tell.adapter.MyPagerAdapter;
import com.example.tell.entity.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import androidx.viewpager.widget.ViewPager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "解答", "咨询"
    };
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ImageView setting;

    public MyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment my.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        viewPager = view.findViewById(R.id.my_viewpager);
        commonTabLayout = view.findViewById(R.id.my_commonTabLayout);
        mFragments.add(new ResolveFragment());
        mFragments.add(new ConsultFragment());
        if (mTabEntities.size() < 2) {
            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i]));
            }
        }
        commonTabLayout.setTabData(mTabEntities);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mTitles, mFragments));
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


        setting = view.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SetActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}