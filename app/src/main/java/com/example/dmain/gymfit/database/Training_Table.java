package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by dmain on 21.03.2018.
 */

public class Training_Table extends SQLiteOpenHelper {



        public static final String DATABASE_NAME = "GYMFIT.db";
        public static final String TABLE_NAME = "TRAINING";
        public static final String COL1 = "ID" ;
        public static final String COL2 = "DATA";



        public Training_Table(Context context) {
            super(context, DATABASE_NAME, null, 34);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL2 +" DATE)";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public boolean addDataTraining(String DATA) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL2, DATA);




            long result = db.insert(TABLE_NAME, null, contentValues);

            //if date as inserted incorrectly it will return -1
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

    public ArrayList<Training> getListContentsSeries(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Training> result = new ArrayList<Training>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {

            String itemData = cursor.getString(
                    cursor.getColumnIndex(Series_Table.COL2));


            Training t = new Training(itemData);
            result.add(t);
        }

        return result;
    }
}