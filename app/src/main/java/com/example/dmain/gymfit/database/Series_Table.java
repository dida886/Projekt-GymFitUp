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

public class Series_Table  {

    public static final String TABLE_NAME = "SERIES";
    public static final String ID_COL = "ID" ;
    public static final String WEIGHT_COL = "WEIGHT";
    public static final String REPS_COL = "REPS";
    public static final String TIME_COL = "TIME";
    public static final String DATE_COL = "DATE";
    public static final String EXERCISE_ID_COL = "EXERCISE_ID";








    public static String createTable() {
        String createTable = "CREATE TABLE " + Series_Table.TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Series_Table.WEIGHT_COL +" TEXT, "
                + Series_Table.REPS_COL + " TEXT,"
                + Series_Table.TIME_COL +" TXT,"
                + Series_Table.DATE_COL +" INT,"
                + Series_Table.EXERCISE_ID_COL + " INT)";

        return createTable;
    }







    public int insertSerie (Serie se) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Series_Table.WEIGHT_COL, se.getWeight());
        contentValues.put(Series_Table.REPS_COL, se.getReps());
        contentValues.put(Series_Table.TIME_COL, se.getTime());
        contentValues.put(Series_Table.EXERCISE_ID_COL, se.getExercise_id());
        contentValues.put(Series_Table.DATE_COL, se.getDate());
        long result = db.insert(TABLE_NAME, null, contentValues);




        return new Serie(Long.toString(result), se.getWeight(), se.getReps(), se.getTime(),se.getDate(),se.getExercise_id());
        DatabaseManager.getInstance().closeDatabase();
    }
    public ArrayList<Serie> getSeries(int exercise_id){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE exercise_id = ?", new String[] {Integer.toString(exercise_id)});

        ArrayList<Serie> result = new ArrayList<Serie>();



        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            String itemID = cursor.getString(
                    cursor.getColumnIndex(Series_Table.ID_COL));
            String itemWeight = cursor.getString(
                    cursor.getColumnIndex(Series_Table.WEIGHT_COL));
            String itemReps = cursor.getString(
                    cursor.getColumnIndex(Series_Table.REPS_COL));
            String itemTime = cursor.getString(
                    cursor.getColumnIndex(Series_Table.TIME_COL));
            String itemDate = cursor.getString(
                    cursor.getColumnIndex(Series_Table.DATE_COL));


            Serie s = new Serie(itemID, itemWeight, itemReps, itemTime,itemDate);
            result.add(s);
        }
        DatabaseManager.getInstance().closeDatabase();
        return result;
    }
   /* public ArrayList<Serie> getListContentsSeriesDate(String date){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE date = ?", new String[] {new String(date)});

        ArrayList<Serie> result = new ArrayList<Serie>();



        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            String itemID = cursor.getString(
                    cursor.getColumnIndex(Series_Table.ID_COL));
            String itemWeight = cursor.getString(
                    cursor.getColumnIndex(Series_Table.WEIGHT_COL));
            String itemReps = cursor.getString(
                    cursor.getColumnIndex(Series_Table.REPS_COL));
            String itemTime = cursor.getString(
                    cursor.getColumnIndex(Series_Table.TIME_COL));
            String itemDate = cursor.getString(
                    cursor.getColumnIndex(Series_Table.DATE_COL));


            Serie sd = new Serie(itemID, itemWeight, itemReps, itemTime,itemDate);
            result.add(sd);
        }
        DatabaseManager.getInstance().closeDatabase();
        return result;

    }
}*/
