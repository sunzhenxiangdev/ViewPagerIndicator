package com.xiang.viewpagerindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private TextView t1;
    private TextView t2;

    private IndicatorView iv_main_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        iv_main_indicator = (IndicatorView) findViewById(R.id.iv_main_indicator);


        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        fragments = new ArrayList<>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(fragmentManager, fragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);

        //设置指示线
        iv_main_indicator.setBorderWidth(5);
        iv_main_indicator.setTriangleWidth(10);
        iv_main_indicator.setViewPager(mViewPager);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.t1:
                t1.setTextSize(20);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.t2:
                t2.setTextSize(20);
                mViewPager.setCurrentItem(1);
                break;
        }
    }
}
