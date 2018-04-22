package com.example.dmain.gymfit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Body_Circuits_Table extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "GYMFIT.db";
    public static final String TABLE_NAME = "body_circuits";
    public static final String ID = "ID";
    public static final String ARM = "ARM";
    public static final String FOREARM = "FOREARM";
    public static final String CHEST = "CHEST";
    public static final String WAIST = "WAIST";
    public static final String THIGH = "THIGH";
    public static final String CALF = "CALF";
    public static final String DATA = "DATA";

    public Body_Circuits_Table(Context context) {
        super(context, DATABASE_NAME, null, 54);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ARM TEXT,FOREARM TEXT,CHEST FOREARM,WAIST TEXT,THIGH TEXT,CALF TEXT,DATA TEXT)";

        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String arm, String forearm, String chest, String waist, String thigh, String calf,String data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ARM,arm);
        contentValues.put(FOREARM,forearm);
        contentValues.put(CHEST,chest);
        contentValues.put(WAIST,waist);
        contentValues.put(THIGH,thigh);
        contentValues.put(CALF,calf);
        contentValues.put(DATA,data);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result ==-1)
            return false;
            else
                return true;

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
}
