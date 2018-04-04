package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by dmain on 16.03.2018.
 */

public class Series_Table extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GYMFIT.db";
    public static final String TABLE_NAME = "SERIES";
    public static final String COL1 = "ID" ;
    public static final String COL2 = "WEIGHT";
    public static final String COL3 = "REPS";
    public static final String COL4 = "TIME";




    public Series_Table(Context context) {
        super(context, TABLE_NAME, null, 37);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Series_Table.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Series_Table.COL2 +" TEXT, " + Series_Table.COL3 + " TEXT," + Series_Table.COL4 +" TXT)";
        db.execSQL(createTable);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Serie addDataSeries(String Weight, String Reps, String Time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Series_Table.COL2, Weight);
        contentValues.put(Series_Table.COL3, Reps);
        contentValues.put(Series_Table.COL4, Time);
        long result = db.insert(TABLE_NAME, null, contentValues);

        return new Serie(Long.toString(result), Weight, Reps, Time);
    }
    public ArrayList<Serie> getListContentsSeries(int exercise_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+exercise_id+" = ?", new String[] {Integer.toString(exercise_id)});

        ArrayList<Serie> result = new ArrayList<Serie>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            String itemID = cursor.getString(
                    cursor.getColumnIndex(Series_Table.COL1));
            String itemWeight = cursor.getString(
                    cursor.getColumnIndex(Series_Table.COL2));
            String itemReps = cursor.getString(
                    cursor.getColumnIndex(Series_Table.COL3));
            String itemTime = cursor.getString(
                    cursor.getColumnIndex(Series_Table.COL4));

            Serie s = new Serie(itemID, itemWeight, itemReps, itemTime);
            result.add(s);
        }

        return result;
    }
}
