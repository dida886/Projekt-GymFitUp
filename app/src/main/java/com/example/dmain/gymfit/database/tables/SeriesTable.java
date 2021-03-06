package com.example.dmain.gymfit.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmain.gymfit.database.DatabaseManager;
import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.models.Series;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by dmain on 16.03.2018.
 */

public class SeriesTable {

    public static final String TABLE_NAME = "SERIES";

    private static final String ID_COL = "ID";
    private static final String EXERCISE_NAME = "EXERCISE_NAME";
    private static final String COLOR_ID_COL = "COLOR_ID";
    private static final String WEIGHT_COL = "WEIGHT";
    private static final String REPS_COL = "REPS";
    private static final String TIME_COL = "TIME";
    private static final String DATE_COL = "DATE";
    private static final String EXERCISE_ID_COL = "EXERCISE_ID";

    public static String createTable() {
        return "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EXERCISE_NAME + " STRING, "
                + COLOR_ID_COL + " INT, "
                + WEIGHT_COL + " DOUBLE, "
                + REPS_COL + " INTEGER,"
                + DATE_COL + " LONG,"
                + TIME_COL + " LONG, "
                + EXERCISE_ID_COL + " INT"
                + ")";
    }

    public static int insert(Series se) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesTable.EXERCISE_NAME, se.getExercisesName());
        contentValues.put(SeriesTable.COLOR_ID_COL, se.getColorID());
        contentValues.put(SeriesTable.WEIGHT_COL, se.getWeight());
        contentValues.put(SeriesTable.REPS_COL, se.getRepetitions());
        contentValues.put(SeriesTable.EXERCISE_ID_COL, se.getExerciseId());
        contentValues.put(SeriesTable.DATE_COL, se.getDate());
        contentValues.put(SeriesTable.TIME_COL, se.getDate());

        int result = (int) db.insert(TABLE_NAME, null, contentValues);
        DatabaseManager.getInstance().closeDatabase();

        return result;
    }

    public static ArrayList<Series> getAll(int newDate) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE " + DATE_COL + " = ?",
                new String[]{Integer.toString(newDate)}
        );

        ArrayList<Series> result = new ArrayList<>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID_COL));

            String name = cursor.getString(cursor.getColumnIndex(EXERCISE_NAME));
            int colorid = cursor.getInt(cursor.getColumnIndex(COLOR_ID_COL));
            double weight = cursor.getDouble(cursor.getColumnIndex(WEIGHT_COL));
            int reps = cursor.getInt(cursor.getColumnIndex(REPS_COL));
            long date = cursor.getLong(cursor.getColumnIndex(DATE_COL));
            int eid = cursor.getInt(cursor.getColumnIndex(EXERCISE_ID_COL));
            String time2 = cursor.getString(cursor.getColumnIndex(TIME_COL));

            Series s = new Series(id, weight, reps, date, eid, name, new Date(time2), colorid);
            result.add(s);
        }
        DatabaseManager.getInstance().closeDatabase();
        return result;
    }

    public static ArrayList<Series> getAll2() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Series> result = new ArrayList<>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID_COL));
            int colorid = cursor.getInt(cursor.getColumnIndex(COLOR_ID_COL));

            String name = cursor.getString(cursor.getColumnIndex(EXERCISE_NAME));
            double weight = cursor.getDouble(cursor.getColumnIndex(WEIGHT_COL));
            int reps = cursor.getInt(cursor.getColumnIndex(REPS_COL));
            long date = cursor.getLong(cursor.getColumnIndex(DATE_COL));
            int eid = cursor.getInt(cursor.getColumnIndex(EXERCISE_ID_COL));
            long time2 = cursor.getLong(cursor.getColumnIndex(TIME_COL));

            Series s = new Series(id, weight, reps, date, eid, name, new Date(time2), colorid);
            result.add(s);
        }
        DatabaseManager.getInstance().closeDatabase();
        return result;
    }


    public static int deleteItem(int position) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TABLE_NAME, ID_COL + "=" + String.valueOf(position), null);

//        Cursor cursor = db.rawQuery("DELETE FROM " + TABLE_NAME + " WHERE " + ID_COL + " = " + String.valueOf(position), null);


//        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return position;


    }
}

