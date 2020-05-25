package com.example.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {


    Context context;


    AlarmDB  pdb;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        //intent 로부터 전달받은 string
        String get_your_string = intent.getExtras().getString("state");

        //다른 서비스 ex)Ringtone

        Intent sIntent = new Intent(context, AlarmService.class);

        // Oreo(26) 버전 이후부터는 Background 에서 실행을 금지하기 때문에 Foreground 에서 실행해야 함
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(sIntent);
        } else {
            context.startService(sIntent);
        }

        /**
         * 만약 켜져 있는 알람이 아니라면 자동 종료 되도록 설정,
         */
        int pid=intent.getIntExtra("pid",-1);
        if(pdb.SelectActive(pid)==0){
            return;
        }


        Calendar cal= Calendar.getInstance();
        int weekday=intent.getIntExtra("week",-1);
        //bit연산을 통해서 해당 요일이 존재하는지 검사합니다.
        if((1<<(cal.get(Calendar.DAY_OF_WEEK))&(1<<weekday))==0){
            Log.e("alarm","오늘은 해당 날짜가 아닙니다");
            return;
        }


    }
}
