package com.example.alarm;

import android.os.Bundle;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.viewpager.widget.ViewPager;

        import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainPagerAdapter mPageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.sa_activity_main);
        mTabLayout = findViewById(R.id.sa_main_tab);
        mViewPager = findViewById(R.id.sa_viewpager);


        // SA : tester ui added!
        // activate this paragraph & inactivate old one to check ui
        // + MainpagerAdapter.java에 있는 것도 활성화 시켜주세요!
        /*
        setContentView(R.layout.sa_activity_main);
        mTabLayout = findViewById(R.id.sa_main_tab);
        mViewPager = findViewById(R.id.sa_viewpager);
        */

        mPageAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);




        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
