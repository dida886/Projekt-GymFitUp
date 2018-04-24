package com.example.dmain.gymfit;


import android.app.Application;
import android.content.Context;

import com.example.dmain.gymfit.database.DBHelper;
import com.example.dmain.gymfit.database.DatabaseManager;
import com.example.dmain.gymfit.database.tables.ExercisesTable;


public class App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper(context);
        DatabaseManager.initializeInstance(dbHelper);

        if (ExercisesTable.getAll().size() == 0){
            ExercisesTable.insertPredefinedData();
        }
    }

    public static Context getContext() {
        return context;
    }

}
