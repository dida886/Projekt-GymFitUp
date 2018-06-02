package com.example.dmain.gymfit.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dmain.gymfit.database.DatabaseManager;
import com.example.dmain.gymfit.database.models.BodyMeasure;

import java.util.ArrayList;
import java.util.Date;

public class BodyMeasuresTable {

    public static final String TABLE_NAME = "BODY_MEASURES";

    public static final String ID_COL = "ID";
    private static final String ARM_COL = "ARM";
    private static final String FOREARM_COL = "FOREARM";
    private static final String CHEST_COL = "CHEST";
    private static final String WAIST_COL = "WAIST";
    private static final String THIGH_COL = "THIGH";
    private static final String CALF_COL = "CALF";
    private static final String DATE_COL = "DATE";

    public static String createTable() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ARM_COL + " DOUBLE, " +
                FOREARM_COL + " DOUBLE, " +
                CHEST_COL + " DOUBLE, " +
                WAIST_COL + " DOUBLE, " +
                THIGH_COL + " DOUBLE, " +
                CALF_COL + " DOUBLE, " +
                DATE_COL + " LONG" +
                ")";
    }

    public static int insert(BodyMeasure bm) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ARM_COL, bm.getArm());
        contentValues.put(FOREARM_COL, bm.getForearm());
        contentValues.put(CHEST_COL, bm.getChest());
        contentValues.put(WAIST_COL, bm.getWaist());
        contentValues.put(THIGH_COL, bm.getTight());
        contentValues.put(CALF_COL, bm.getCalf());
        contentValues.put(DATE_COL, bm.getDate().getTime());

        int id = (int) db.insert(TABLE_NAME, null, contentValues);
        DatabaseManager.getInstance().closeDatabase();

        return id;

    }

    public static ArrayList<BodyMeasure> getAll() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<BodyMeasure> result = new ArrayList<>();

        if (cursor.getCount() == 0) {
            return result;
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID_COL));
            double arm = cursor.getDouble(cursor.getColumnIndex(ARM_COL));
            double forearm = cursor.getDouble(cursor.getColumnIndex(FOREARM_COL));
            double chest = cursor.getDouble(cursor.getColumnIndex(CHEST_COL));
            double waist = cursor.getDouble(cursor.getColumnIndex(WAIST_COL));
            double thigh = cursor.getDouble(cursor.getColumnIndex(THIGH_COL));
            double calf = cursor.getDouble(cursor.getColumnIndex(CALF_COL));
            long date = cursor.getLong(cursor.getColumnIndex(DATE_COL));

            result.add(new BodyMeasure(id, arm, forearm, chest, waist, thigh, calf, new Date(date)));
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return result;

    }
    public static int deleteItem(int position){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery("DELETE FROM " + TABLE_NAME + " WHERE " + ID_COL + " = " + position, null);



        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return position;



    }





}
