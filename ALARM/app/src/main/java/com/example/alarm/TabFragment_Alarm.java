package com.example.alarm;


import android.animation.ArgbEvaluator;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;

import android.widget.DatePicker;
import android.widget.TimePicker;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.alarm.alarm_card.Adapter;
import com.example.alarm.alarm_card.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Objects;

public class TabFragment_Alarm extends Fragment {

    int cnt= 0;
    ViewPager alarm_viewpager;
    Adapter adapter;

import java.util.Locale;

public class TabFragment_Alarm extends Fragment {
    private View view;

    List<Model> models;
    Adapter adapter;
    AlarmDB  pdb;
    Context mContext;
    String[] sSize;

    // 알람 시간
    private Calendar calendar;
    static int cnt=3;
    private TimePicker timePicker;
    public static TabFragment_Alarm newinstance()
    {
        TabFragment_Alarm tabFragmentAlarm =new TabFragment_Alarm();
        return tabFragmentAlarm;
    }
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_alarm, null);

        Button button1 = (Button)view.findViewById(R.id.btnSet);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent1 = new Intent(getActivity(), AlarmSetActivity.class);
                  startActivity(intent1);
            }
        });

//        Button button2 = (Button)view.findViewById(R.id.btnSet2);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(TabFragment_AlarmSet.newinstance());
//            }
//        });

//        ImageButton button3 = (ImageButton)view.findViewById(R.id.image);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(TabFragment_AlarmSet.newinstance());
//            }
//        });

        if(getArguments()!=null)
        {
            cnt=getArguments().getInt("cnt");
            Toast.makeText(view.getContext(), "Alarm : " , Toast.LENGTH_LONG).show();
        }
        Toast.makeText(view.getContext(), "Alarm : " , Toast.LENGTH_LONG).show();
        models = new ArrayList<>();
        for(int i = 0; i< TabFragment_AlarmSet.cnt; i++)
        {
            models.add(new Model(R.drawable.brochure, Integer.toString(i), Integer.toString(i)+"번째알람"));

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedinstanceState){
        view=inflater.inflate(R.layout.tab_fragment_alarm,container,false);
        this.calendar = Calendar.getInstance();
        // 현재 날짜 표시
        displayDate();

        this.timePicker = view.findViewById(R.id.timePicker);
        //Calender,알람버튼에 리스너 추가
        view.findViewById(R.id.btnCalendar).setOnClickListener(mClickListener);
        view.findViewById(R.id.btnAlarm).setOnClickListener(mClickListener);
        return view;
    }


    /* 날짜 표시 */
    private void displayDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        //((TextView) findViewById(R.id.txtDate)).setText(format.format(this.calendar.getTime()));
    }



    /* 알람 등록 */
    private void setAlarm() {
        //DB실험
        mContext = getContext();
        pdb = new AlarmDB (mContext); // SizerDB 연동 클래스 인스턴스


        // 알람 시간 설정
        this.calendar.set(Calendar.HOUR_OF_DAY, this.timePicker.getHour());
        this.calendar.set(Calendar.MINUTE, this.timePicker.getMinute());
        this.calendar.set(Calendar.SECOND, 0);

        // 현재일보다 이전이면 등록 실패
        if (this.calendar.before(Calendar.getInstance())) {
            Toast.makeText(view.getContext(), "알람시간이 현재시간보다 이전일 수 없습니다.", Toast.LENGTH_LONG).show();
            return;

        }

        /**
            요일 추가하는거(레이아웃 완성되면 추가 할 부분), 비트 연산으로 해당 요일값 추가
         int week;
         week+=1<<view.findViewId(R.id.btnWeek1) //일요일
         week+=1<<view.findViewId(R.id.btnWeek2) //월요일
         week+=1<<view.findViewId(R.id.btnWeek3)
         week+=1<<view.findViewId(R.id.btnWeek4)
         week+=1<<view.findViewId(R.id.btnWeek5)
         week+=1<<view.findViewId(R.id.btnWeek6)
         week+=1<<view.findViewId(R.id.btnWeek7) //토요일

         */




            }
        });
        return view;

        /**
                Receiver 설정
                Receiver에 알람이 울릴 요일을 전달. 1이 일요일, 7이 토요일 의미!
                Receiver에 PID 전달

         **/

        Intent intent = new Intent(view.getContext(), AlarmReceiver.class);
        intent.putExtra("week",calendar.get(Calendar.DAY_OF_WEEK));
        intent.putExtra("pid",pdb.SelectPid()+1);
        Fragment fragment =new TabFragment_Info();
        Bundle bundle =new Bundle();
        bundle.putInt("cnt",cnt);
        fragment.setArguments(bundle);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(view.getContext(), cnt++, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        //알람 DB에 저장하기
        pdb.insert(pdb.SelectPid()+1,calendar.get(Calendar.DAY_OF_WEEK),1,1,1,"첫 생성입니다",1,this.timePicker.getHour(),this.timePicker.getMinute());
        int[][] t=pdb.SelectTime(pdb.SelectPid());
        Log.d("AlarmDB",Integer.toString(pdb.SelectPid())+Integer.toString(t[0][0])+"요일"+Integer.toString(t[0][1])+"시"+Integer.toString(t[0][2])+"분");
        // 알은 24시간만다 반복되도록 설정
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(view.getContext().ALARM_SERVICE);
        long oneday = 24 * 60 * 60 * 1000;// 24시간 마다 반복
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, this.calendar.getTimeInMillis(),oneday, pendingIntent);

        // Toast 보여주기 (알람 시간 표시)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Toast.makeText(view.getContext(), "Alarm : "+Integer.toString(cnt) + format.format(calendar.getTime()), Toast.LENGTH_LONG).show();

    }


    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAlarm:
                    // 알람 등록
                    setAlarm();

                    break;
            }
        }
    };
}
