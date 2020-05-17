package com.example.alarm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //프래그 먼트 교체
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return FragMonday.newinstance();
            case 1:
                return setting.newinstance(); // 나중에 생성해주자
            default:
                return null;

        }
    }

    //
    @Override
    public int getCount() {
        return 2; //총 페이지의 갯수를 return 해주자.
    }


    //상단의 탭 인디케이터 쪽에 텍스트 선언
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Main";
            case 1:
                return "Setting"; // 나중에 생성해주자
            default:
                return null;

        }
    }
}
