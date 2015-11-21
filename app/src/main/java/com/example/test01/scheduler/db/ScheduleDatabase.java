package com.example.test01.scheduler.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.test01.scheduler.BasicInfo;


public class ScheduleDatabase {

    public static final String TAG = "ScheduleDatabase";

    /**
     * 싱글톤 인스턴스
     */
    private static ScheduleDatabase database;

    /**
     * table name for MEMO
     */
    public static String TABLE_SCHEDULE = "SCHEDULE";

    /**
     * version
     */
    public static int DATABASE_VERSION = 1;


    /**
     * Helper class defined
     */
    private DatabaseHelper dbHelper;

    /**
     * SQLiteDatabase 인스턴스
     */
    private SQLiteDatabase db;

    /**
     * 컨텍스트 객체
     */
    private Context context;

    /**
     * 생성자
     */
    private ScheduleDatabase(Context context) { this.context = context;
    }

    /**
     * 인스턴스 가져오기
     */
    public static ScheduleDatabase getInstance(Context context) {
        if (database == null) {
            database = new ScheduleDatabase(context);
        }

        return database;
    }
    /**
     * 데이터베이스 열기
     */
    public boolean open() {
        println("opening database [" + BasicInfo.DATABASE_NAME + "].");
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return true;
    }

    /**
     * 데이터베이스 닫기
     */
    public void close() {
        println("closing database [" + BasicInfo.DATABASE_NAME + "].");
        db.close();

        database = null;
    }


    public Cursor rawQuery(String SQL) {
        println("\nexecuteQuery called.\n");

        Cursor c1 = null;
        try {
            c1 = db.rawQuery(SQL, null);
            println("cursor count : " + c1.getCount());
        } catch(Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
        }

        return c1;
    }

    public boolean execSQL(String SQL) {
        println("\nexecute called.\n");

        try {
            Log.d(TAG, "SQL : " + SQL);
            db.execSQL(SQL);
        } catch(Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
            return false;
        }

        return true;
    }



    /**
     * Database Helper inner class
     */
    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, BasicInfo.DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            println("creating database [" + BasicInfo.DATABASE_NAME + "].");

            // TABLE_MEMO
            println("creating table [" + TABLE_SCHEDULE + "].");

            // drop existing table
            String DROP_SQL = "drop table if exists " + TABLE_SCHEDULE;

            try {
                db.execSQL(DROP_SQL);
            } catch (Exception ex) {
                Log.e(TAG, "Exception in DROP_SQL", ex);
            }


            // create table
            String CREATE_SQL = "create table " + TABLE_SCHEDULE + "("
                    + "  _id INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + "  INPUT_DATE TIMESTAMP, "
                    + "  INPUT_TIME TIMESTAMP, "
                    + "  CONTENT_TEXT TEXT DEFAULT '' "
                    + ")";
            try {
                db.execSQL(CREATE_SQL);
            } catch (Exception ex) {
                Log.e(TAG, "Exception in CREATE_SQL", ex);
            }
        }

        public void onOpen(SQLiteDatabase db)
        {
            println("opened database [" + BasicInfo.DATABASE_NAME + "].");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            println("Upgrading database from version " + oldVersion + " to " + newVersion + ".");


        }

    }


    private void println(String msg) {Log.d(TAG, msg);}
}
