package com.example.dmain.gymfit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.ExercisesTable;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity {

    ListView mListView;
    BaseAdapter mBaseAdapter;
    CalendarView mCalendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        mListView = findViewById(R.id.datelist);
        mCalendarView = findViewById(R.id.calendar);

//        ArrayList<> theList = new ArrayList<>();
//        mBaseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);

        Intent intent = getIntent();
        final Integer date = intent.getIntExtra("DATE", -1);

    }
}