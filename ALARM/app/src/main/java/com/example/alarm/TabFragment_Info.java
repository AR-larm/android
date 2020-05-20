package com.example.alarm;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.alarm.alarm_card.Adapter;
import com.example.alarm.alarm_card.Model;

import java.util.ArrayList;
import java.util.List;

public class TabFragment_Info extends Fragment {

    ViewPager alarm_viewpager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_info, null);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Brochure", "Brochure is an informative"));
        models.add(new Model(R.drawable.sticker, "Sticker", "Sticker is a type of label"));
        models.add(new Model(R.drawable.poster, "Poster", "Poster is any piece of "));
        models.add(new Model(R.drawable.namecard, "Namecard", "Business cards are cards bearing"));

        adapter = new Adapter(models, getContext());

        alarm_viewpager=view.findViewById(R.id.alarm_viewpager);
        alarm_viewpager.setAdapter(adapter);
        alarm_viewpager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        alarm_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount() - 1) && position< (colors.length - 1)){
                    alarm_viewpager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position+1]));
                }else{
                    alarm_viewpager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }
}
