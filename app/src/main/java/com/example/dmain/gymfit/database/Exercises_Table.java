package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dmain on 21.03.2018.
 */

public class Exercises_Table extends SQLiteOpenHelper {



        public static final String DATABASE_NAME = "GYMFIT.db";
        public static final String TABLE_NAME = "EXERCISES";
        public static final String COL1 = "ID" ;
        public static final String COL2 = "ID_TRAINING";
        public static final String COL3 = "ID_LIST_EXERCISES";


        public Exercises_Table(Context context) {
            super(context, DATABASE_NAME, null, 37);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "create table "
                    + Exercises_Table.TABLE_NAME + " ("
                    + Exercises_Table.COL1 + " integer primary key autoincrement, "
                    + Exercises_Table.COL2 + " integer, "
                    + Exercises_Table.COL3 + " integer, "
                    + " FOREIGN KEY ("+ Exercises_Table.COL2+") REFERENCES "+ Training_Table.TABLE_NAME+" ("+ Training_Table.COL1+")"
                    + " FOREIGN KEY ("+ Exercises_Table.COL3+") REFERENCES "+ List_Exercises_Table.TABLE_NAME+" ("+ List_Exercises_Table.COL1+"));";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
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

