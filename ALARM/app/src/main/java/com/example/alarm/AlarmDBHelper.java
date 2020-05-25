package com.example.alarm;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Constants;
import android.util.Log;



/**
 *

 * DB 연동 관련 클래스
 * 조회
 *
 *
 * @author	d.h.shin
 * @version	1.0
 * @date	2012. 5. 3.
 * @see
 */



/**
 *

 * DB 생성 및 update
 *


 *
 */
class AlarmDBHelper extends SQLiteOpenHelper {
    Context mContext;
    public AlarmDBHelper(Context context) {
        // Database이름은 실제 단말상에서 생성될 파일이름입니다. data/data/package명/databases/DATABASE_NAME식으로 저장
        super(context, "alarm.db", null, 1);	// 제일 마지막 인자 : 버젼, 만약 버젼이 높아지면 onUpgrade를 수행한다.
        mContext =  context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
