package com.example.dmain.gymfit.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmain.gymfit.database.DatabaseManager;
import com.example.dmain.gymfit.database.models.ListExercise;

import java.util.ArrayList;

/**
 * Created by dmain on 21.03.2018.
 */

public class ExercisesTable {

    public static final String TABLE_NAME = "LIST_EXERCISES";

    private static final String ID_COL = "ID";
    private static final String NAME_COL = "NAME";
    private static final String COLOR_COL = "COLOR";

    public static String createTable() {
        return "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT"
                + COLOR_COL + " TEXT" +
                ")";
    }

    public static void insertPredefinedData(){
        ExercisesTable.insert(new ListExercise(1, "Podnoszenie Sztangi","#cc0000"));
        ExercisesTable.insert(new ListExercise(2, "Mięśnie łydek","#10ad01"));
        ExercisesTable.insert(new ListExercise(3, "Mięśnie brzucha","#0148ad"));
    }

    public static int insert(ListExercise le) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COL, le.getName());
        contentValues.put(COLOR_COL, le.getColor());

        int id = (int)db.insert(TABLE_NAME, null, contentValues);
        DatabaseManager.getInstance().closeDatabase();

        return id;
    }

    public static ArrayList<ListExercise> getAll() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ListExercise> result = new ArrayList<ListExercise>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ExercisesTable.ID_COL));
            String Name = cursor.getString(cursor.getColumnIndex(ExercisesTable.NAME_COL));
            String Color = cursor.getString(cursor.getColumnIndex(ExercisesTable.COLOR_COL));

            result.add(new ListExercise(id,Name,null));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return result;
    }
    public static ArrayList<ListExercise> getName2() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT "+NAME_COL+" FROM " + TABLE_NAME, null);

        ArrayList<ListExercise> result = new ArrayList<ListExercise>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
           int id = cursor.getInt(cursor.getColumnIndex(ExercisesTable.ID_COL));
            String Name = cursor.getString(cursor.getColumnIndex(ExercisesTable.NAME_COL));
            //String Color =cursor.getString(cursor.getColumnIndex(ExercisesTable.COLOR_COL));


            result.add(new ListExercise(id,Name,null));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return result;
    }



}


