package com.example.test01.scheduler;

import java.text.SimpleDateFormat;

/**
 * Created by SOYOUNG on 2015-11-15.
 */
public class BasicInfo {
    public static String language = "";



    public static String ExternalPath = "/mnt/sdcard/";

    public static boolean ExternalChecked = false;


    public static String DATABASE_NAME = "schedule/schedule.db";


    public static final String KEY_MEMO_MODE = "MEMO_MODE";
    public static final String KEY_MEMO_TEXT = "MEMO_TEXT";
    public static final String KEY_MEMO_ID = "MEMO_ID";
    public static final String KEY_MEMO_DATE = "MEMO_DATE";
    public static final String KEY_MEMO_TIME = "MEMO_TIME";


    public static final String MODE_INSERT = "MODE_INSERT";
    public static final String MODE_MODIFY = "MODE_MODIFY";
    public static final String MODE_VIEW = "MODE_VIEW";


    public static final int REQ_VIEW_ACTIVITY = 1001;
    public static final int REQ_INSERT_ACTIVITY = 1002;


    public static SimpleDateFormat dateDayNameFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    public static SimpleDateFormat dateDayFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateNameFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
    public static SimpleDateFormat dateNameFormat2 = new SimpleDateFormat("yyyy-MM-dd HH시 mm분");
    public static SimpleDateFormat dateNameFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static SimpleDateFormat dateTimeNameFormat = new SimpleDateFormat("HH시 mm분");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("HH:mm");



    public static final int CONFIRM_DELETE = 3001;

    public static final int CONFIRM_TEXT_INPUT = 3002;
}
