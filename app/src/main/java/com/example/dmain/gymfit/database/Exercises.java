package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dmain on 21.03.2018.
 */

public class Exercises extends SQLiteOpenHelper {



        public static final String DATABASE_NAME = "GYMFIT.db";
        public static final String TABLE_NAME = "EXERCISES";
        public static final String COL1 = "ID" ;
        public static final String COL2 = "ID_TRAINING";
        public static final String COL3 = "ID_LIST_EXERCISES";


        public Exercises(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FOREIGN KEY(ID_TRAINING) REFERENCES Training(ID) "+ "FOREIGN KEY(ID_LIST_EXERCISES) REFERENCES List_Exercises(ID)) ";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public boolean addDataExercises(String item1, String item2) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL2, item1);
            contentValues.put(COL3, item2);



            long result = db.insert(TABLE_NAME, null, contentValues);

            //if date as inserted incorrectly it will return -1
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        public Cursor getListContentsExercises(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return data;
        }
    }

