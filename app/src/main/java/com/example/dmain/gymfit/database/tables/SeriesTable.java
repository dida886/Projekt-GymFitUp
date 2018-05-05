package com.example.dmain.gymfit.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmain.gymfit.database.DatabaseManager;
import com.example.dmain.gymfit.database.models.Series;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by dmain on 16.03.2018.
 */

public class SeriesTable {

    public static final String TABLE_NAME = "SERIES";

    private static final String ID_COL = "ID" ;
    private static final String WEIGHT_COL = "WEIGHT";
    private static final String REPS_COL = "REPS";
    private static final String TIME_COL = "TIME";
    private static final String DATE_COL = "DATE";
    private static final String EXERCISE_ID_COL = "EXERCISE_ID";

    public static String createTable() {
        return "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WEIGHT_COL +" DOUBLE, "
                + REPS_COL + " INTEGER,"
                + DATE_COL +" LONG,"
                + EXERCISE_ID_COL + " INT"
                + ")";
    }

    public static int insert(Series se) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesTable.WEIGHT_COL, se.getWeight());
        contentValues.put(SeriesTable.REPS_COL, se.getRepetitions());
        contentValues.put(SeriesTable.EXERCISE_ID_COL, se.getExerciseId());
        contentValues.put(SeriesTable.DATE_COL, se.getDate().getTime());

        int result = (int)db.insert(TABLE_NAME, null, contentValues);
        DatabaseManager.getInstance().closeDatabase();

        return result;
    }
    public static ArrayList<Series> getAll(int exerciseId){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE " + EXERCISE_ID_COL + " = ?",
                new String[] {Integer.toString(exerciseId)}
        );

        ArrayList<Series> result = new ArrayList<>();

        if(cursor.getCount() == 0){
            return result;
        }

        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID_COL));

            double weight = cursor.getDouble(cursor.getColumnIndex(WEIGHT_COL));
            int reps = cursor.getInt(cursor.getColumnIndex(REPS_COL));
            long date = cursor.getLong(cursor.getColumnIndex(DATE_COL));
            int eid = cursor.getInt(cursor.getColumnIndex(EXERCISE_ID_COL));

            Series s = new Series(id, weight, reps, new Date(date), eid);
            result.add(s);
        }
        DatabaseManager.getInstance().closeDatabase();
        return result;
    }
}
