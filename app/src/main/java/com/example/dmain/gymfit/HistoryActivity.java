package com.example.dmain.gymfit;


import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.usage.UsageEvents;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.ListExercise;
import com.example.dmain.gymfit.database.List_Exercises_Table;
import com.example.dmain.gymfit.database.Serie;
import com.example.dmain.gymfit.database.Series_Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Calendar.DATE;

public class HistoryActivity extends AppCompatActivity {

    List_Exercises_Table myDB;
    ListView listView;
    ArrayList theList;
    BaseAdapter baseAdapter;
    CalendarView simpleCalendarView;
    Series_Table dbSerie_table;
    Serie serie;


    private SimpleDateFormat dateFormaMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        listView = (ListView) findViewById(R.id.datelist);

        theList = new ArrayList<>();
        baseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);

        //final ArrayList<Serie>  seriedata = dbSerie_table.getListContentsSeriesDate(date)

        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendar); // get the reference of CalendarView
        Intent intent = getIntent();
        final Integer date = intent.getIntExtra("DATE", -1);


        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month=month+1;
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                //final ArrayList<Serie>  seriedata = dbSerie_table.getListContentsSeriesDate(serie.getDate());
                //seriedata.toString();




                ArrayList<Serie> series = dbSerie_table.getListContentsSeriesDate(date.toString());
                Integer calendarz = date;



                    if (dayOfMonth+month+year==calendarz) {


                    final ArrayList<ListExercise> exercises = myDB.getList_Exercises();


                    if (exercises.size() == 0) {
                        // Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();

                    } else {

                        for (ListExercise e : exercises) theList.add(e.toString());

                        listView.setAdapter(baseAdapter);

                    }

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            Intent intent = new Intent(view.getContext(), History_DetailsActivity.class);
                            intent.putExtra("EXERCISE_ID", exercises.get(position).Id);

                            startActivityForResult(intent, position);


                        }
                    });


                }
                else {
                    Toast.makeText(getApplicationContext(), "Nie wykonano ćwiczeń", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}