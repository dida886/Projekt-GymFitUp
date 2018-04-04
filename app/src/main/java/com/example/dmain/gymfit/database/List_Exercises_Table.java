package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by dmain on 21.03.2018.
 */

public class List_Exercises_Table extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "GYMFIT.db";
    public static final String TABLE_NAME = "LIST_EXERCISES";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";


    public List_Exercises_Table(Context context) {
        super(context, DATABASE_NAME, null, 37);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + List_Exercises_Table.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " TEXT)";
        db.execSQL(createTable);

        String insertsql = "INSERT OR REPLACE INTO " + List_Exercises_Table.TABLE_NAME + " (" + List_Exercises_Table.COL2 + ") VALUES('Podnoszenie Sztangi'),('Skłony')";


        db.execSQL(insertsql);


        Log.d("ZWRACANIE BAZY", "ITEMS: ");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addDataList_Exercises(String Name, String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, Name);



        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public ArrayList<ListExercise> getListContentsList_Exercises(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ListExercise> result = new ArrayList<ListExercise>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            String Name = cursor.getString(
                    cursor.getColumnIndex(List_Exercises_Table.COL2));


            ListExercise e = new ListExercise(Name);
            result.add(e);
        }

        return result;
    }

}

