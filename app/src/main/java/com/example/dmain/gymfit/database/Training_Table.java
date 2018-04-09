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
        public static final String ID_COL = "ID" ;
        public static final String DATA_COL = "DATA";



        public Training_Table(Context context) {
            super(context, DATABASE_NAME, null, 37);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + Training_Table.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Training_Table.DATA_COL +" DATE)";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Training_Table.TABLE_NAME);
            onCreate(db);
        }

        public boolean addDataTraining(String DATA) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Training_Table.DATA_COL, DATA);




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
        Cursor cursor = db.rawQuery("SELECT * FROM " + Training_Table.TABLE_NAME, null);

        ArrayList<Training> result = new ArrayList<Training>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {

            String itemData = cursor.getString(
                    cursor.getColumnIndex(Training_Table.DATA_COL));


            Training t = new Training(itemData);
            result.add(t);
        }

        return result;
    }
}