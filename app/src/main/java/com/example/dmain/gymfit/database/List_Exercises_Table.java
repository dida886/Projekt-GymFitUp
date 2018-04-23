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

public class List_Exercises_Table {

    public static final String TABLE_NAME = "LIST_EXERCISES";
    public static final String ID_COL = "ID";
    public static final String NAME_COL = "NAME";

    public static String createTable() {
        String createTable = "CREATE TABLE " + List_Exercises_Table.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT)";
        return createTable;
    }

    public void insertPredefineadData(){
        this.insert(new ListExercise(-1, "Podnoszenie Sztangi"));
        this.insert(new ListExercise(-1, "Skłony"));
    }

    public int insert(ListExercise le) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COL, le.getName());

        int id = (int)db.insert(TABLE_NAME, null, contentValues);
        DatabaseManager.getInstance().closeDatabase();

        return id;
    }

    public ArrayList<ListExercise> getList_Exercises() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ListExercise> result = new ArrayList<ListExercise>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(List_Exercises_Table.ID_COL));
            String Name = cursor.getString(cursor.getColumnIndex(List_Exercises_Table.NAME_COL));

            result.add(new ListExercise(id, Name));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return result;
    }



}


