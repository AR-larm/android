package com.example.alarm;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static int pagecount  = 4;
    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:
                TabFragment_Info tabFragment_info = new TabFragment_Info();
                return tabFragment_info;
            case 1:
                TabFragment_Alarm tabFragment_alarm = new TabFragment_Alarm();
                return tabFragment_alarm;
            case 2:
                TabFragment_Statistic tabFragment_statistic = new TabFragment_Statistic();
                return tabFragment_statistic;
            case 3:

                TabFragment_Setting tabFragment_setting = new TabFragment_Setting();
                return tabFragment_setting;

                TabFragment_Statistic tabFragment_statistic1 = new TabFragment_Statistic();
                return tabFragment_statistic1;

            default:
                return null;
        }


        // SA : tester ui added!
        // activate this paragraph & inactivate old one to check ui
        // + MainActivity.java에 있는 것도 활성화 시켜주세요!
        /*
        switch (position){
            case 0:
                sa_TabFragment_Info tabFragment_info = new sa_TabFragment_Info();
                return tabFragment_info;
            case 1:
                sa_TabFragment_Alarm tabFragment_alarm = new sa_TabFragment_Alarm();
                return tabFragment_alarm;
            case 2:
                sa_TabFragment_Statistic tabFragment_statistic = new sa_TabFragment_Statistic();
                return tabFragment_statistic;
            case 3:
                sa_TabFragment_Sysset tabFragment_sysset = new sa_TabFragment_Sysset();
                return tabFragment_sysset;


            default:
                return null;
        }
*/

    }

    @Override
    public int getCount() {
        return pagecount;
    }
}
