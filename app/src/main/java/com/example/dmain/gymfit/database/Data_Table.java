package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Data_Table extends SQLiteOpenHelper {public static final String DATABASE_NAME = "GYMFIT.db";
    public static final String TABLE_NAME = "DATA";
    public static final String ID_COL = "ID" ;
    public static final String DATE_COL = "TXT";
    public static final String LIST_EXERCISE_ID_COL = "INT";





    public Data_Table(Context context) {
        super(context, TABLE_NAME, null, 54);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Data_Table.TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +

                 Data_Table.DATE_COL +" TXT,"
                + Data_Table.LIST_EXERCISE_ID_COL + " INT)";

        db.execSQL(createTable);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addDataData(String Data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DATE_COL, Data);








        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public ArrayList<Data> getListContentsList_Exercises(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Data> result = new ArrayList<Data>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            String Data = cursor.getString(
                    cursor.getColumnIndex(Data_Table.DATE_COL));
            int id = cursor.getInt(
                    cursor.getColumnIndex(Data_Table.ID_COL));

            Data e = new Data(id, Data);
            result.add(e);
        }

        return result;
    }

}



