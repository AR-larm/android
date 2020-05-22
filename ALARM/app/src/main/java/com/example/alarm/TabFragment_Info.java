package com.example.alarm;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.alarm.alarm_card.Adapter;
import com.example.alarm.alarm_card.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class TabFragment_Info extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_info, null);

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
