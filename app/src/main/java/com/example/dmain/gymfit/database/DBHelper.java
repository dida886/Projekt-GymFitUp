package com.example.dmain.gymfit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "GYMFIT2.db";
    private static final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(List_Exercises_Table.createTable());

        List_Exercises_Table let = new List_Exercises_Table();
        let.insertPredefineadData();

        db.execSQL(Series_Table.createTable());




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        db.execSQL("DROP TABLE IF EXISTS " + List_Exercises_Table.TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + Series_Table.TABLE_NAME);
        onCreate(db);
    }

}