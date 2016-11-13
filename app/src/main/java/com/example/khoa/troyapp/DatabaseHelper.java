package com.example.khoa.troyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by khoa on 11/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Class.db";
    public static final String TABLE_NAME="class_table";
    public static final String ID="ID";
    public static final String COL_1="NAME";
    public static final String COL_2="BUILDINGS";
    public static final String COL_3="STARTTIME";
    public static final String COL_4="ENDTIME";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_1 + " TEXT," +
                COL_2 + " TEXT," +
                COL_3 + " INTEGER," +
                COL_4 + " INTEGER)");
        Log.i ("DatabaseHelper.onCreate", "Database created successfully");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ TABLE_NAME);
        onCreate(db);
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean insert(String name, String buildings, String time1, String time2)
    {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();
        contentValues.put (COL_1, name);
        contentValues.put (COL_2, buildings);
        contentValues.put (COL_3, time1);
        contentValues.put (COL_4, time2);
        return (db.insert (TABLE_NAME, null, contentValues) != -1);
    }
}
