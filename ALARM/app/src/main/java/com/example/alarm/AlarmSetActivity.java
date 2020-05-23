package com.example.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.alarm.alarm_card.Adapter;
import com.example.alarm.alarm_card.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AlarmSetActivity extends AppCompatActivity {

    private View view;
    List<Model> models;
    Adapter adapter;

    //알람시간 변수
    private Calendar calendar;
    static int cnt = 3; //수정필요
    private TimePicker timePicker;

    AlarmManager alarm_manager;
    Context context;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);



//        this.context = this;
//
//        //알람 매니저 설정
//        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        //타임피커 설정
//        timePicker = findViewById(R.id.timePicker);
//
//        //Calendar 객체 생성
//        final Calendar calendar = Calendar.getInstance();
//
//        //알람 리시버 Intent 생성
//        final Intent my_intent = new Intent(this.context, AlarmReceiver.class);
//
//        //알람 시작 버튼
//        Button alarm_on = findViewById(R.id.btnAlarm);
//        alarm_on.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//
//                //calendar에 시간 세팅
//                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
//                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
//
//                //시간 가져오기
//                int hour = alarm_timepicker.getHour();
//                int minute = alarm_timepicker.getMinute();
//                Toast.makeText(AlarmSetActivity.this,
//                        "Alarm 예정 " + hour + "시 " + minute + "분", Toast.LENGTH_SHORT).show();
//
//                //receiver에 string 값 넘겨주기
//                my_intent.putExtra("state", "alarm on");
//
//                pendingIntent = PendingIntent.getBroadcast(AlarmSetActivity.this, 0, my_intent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//
//                //알람 세팅
//                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                        pendingIntent);
//
//            }
//        });
//
//        //알람 정지 버튼
//        // Button alarm_off = findViewById(R.id)

    }

}
