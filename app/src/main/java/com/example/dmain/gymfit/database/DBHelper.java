package com.example.dmain.gymfit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;
import com.example.dmain.gymfit.database.tables.ExercisesTable;
import com.example.dmain.gymfit.database.tables.SeriesTable;

public class DBHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 48;
    private static final String DATABASE_NAME = "GYMFIT2.db";
    private static final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ExercisesTable.createTable());
        db.execSQL(BodyMeasuresTable.createTable());
        db.execSQL(SeriesTable.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        db.execSQL("DROP TABLE IF EXISTS " + ExercisesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BodyMeasuresTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SeriesTable.TABLE_NAME);

        onCreate(db);
    }

}