package com.example.alarm;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.alarm.alarm_card.Adapter;
import com.example.alarm.alarm_card.Model;

import java.util.ArrayList;
import java.util.List;

public class TabFragment_Alarm extends Fragment {

    static int cnt=4;
    ViewPager alarm_viewpager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_alarm, null);

        if(getArguments()!=null)
        {
            cnt=getArguments().getInt("cnt");
            Toast.makeText(view.getContext(), "Alarm : " , Toast.LENGTH_LONG).show();
        }
        Toast.makeText(view.getContext(), "Alarm : " , Toast.LENGTH_LONG).show();
        models = new ArrayList<>();
        for(int i = 1; i< TabFragment_Alarm.cnt + 1; i++)
        {
            models.add(new Model(R.drawable.brochure, Integer.toString(i), Integer.toString(i)+"번째알람"));
        }

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

//        Button btn1 = (Button) Objects.requireNonNull(getView()).findViewById(R.id.button);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent1 = new Intent(getActivity(), SettingsActivity.class);
//                startActivity(intent1);
//            }
//        });

        return view;
    }
}
