package com.example.alarm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class setting extends Fragment {
    private View view;

    public static setting newinstance()
    {
        setting setting=new setting();
        return setting;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedinstanceState){
        view=inflater .inflate(R.layout.setting,container,false);
        return view;
    }


}
