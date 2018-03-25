package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;


/**
 * Created by dmain on 16.03.2018.
 */

public class Series extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GYMFIT.db";
    public static final String TABLE_NAME = "SERIES";
    public static final String COL1 = "ID" ;
    public static final String COL2 = "WEIGHT";
    public static final String COL3 = "REPS";
    public static final String COL4 = "TIME";




    public Series(Context context) {
        super(context, TABLE_NAME, null, 6);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Series.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Series.COL2 +" TEXT, " + Series.COL3 + " TEXT," + Series.COL4 +" TXT)";
        db.execSQL(createTable);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addDataSeries(String Weight, String Reps) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Series.COL2, Weight);
        contentValues.put(Series.COL3, Reps);



        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContentsSeries(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
