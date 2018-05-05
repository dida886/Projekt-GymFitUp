package com.example.dmain.gymfit;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.HistoryListAdapter;
import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.ExercisesTable;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity {


    HistoryListAdapter adapter;
    List<Series> series;
    ListView mListView;

     ArrayList<String> theList = new ArrayList<>();



    TextView textCalendar;
    Calendar calendar;
    FloatingActionButton addbtn;
    Dialog myDialog, myDialog2;
    BaseAdapter baseAdapter;


    int day, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);


        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.popup_addexercise);

        addbtn = findViewById(R.id.btnADD);

        textCalendar = findViewById(R.id.textDate);

        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        month = month + 1;

        textCalendar.setText(day + "/" + month + "/" + year);


        textCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(HistoryActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfWeek) {
                        month = month + 1;
                        textCalendar.setText(dayOfWeek + "/" + month + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        mListView = findViewById(R.id.datelist);

        final ArrayList<Series> series = SeriesTable.getAll2();
        adapter = new HistoryListAdapter(getApplicationContext(),series);

        if (series.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            mListView.setAdapter(adapter);

        }








        /*Intent intent = getIntent();
        final int date = intent.getIntExtra("DATE",0);

        mListView = findViewById(R.id.datelist);
        baseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
        mListView.setAdapter(baseAdapter);

        ArrayList<Series> series = SeriesTable.getAllDate(date);

        if (series.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            for (Series s : series) theList.add(s.toString());

        }*/






        addbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {





                Button btnAdd;
                final EditText editText, editText2;
                final ArrayList<String> theList = new ArrayList<>();
                final ArrayAdapter adapter;





                Intent intent1= new Intent();

                final int exercise_id = intent1.getIntExtra("EXERCISE_ID", -1);


                editText = myDialog.findViewById(R.id.txtinput);
                editText2 = myDialog.findViewById(R.id.txtinput2);
                btnAdd = myDialog.findViewById(R.id.btadd);
                final Spinner spinner = myDialog.findViewById(R.id.spinner);

                final ArrayList<ListExercise> exercises = ExercisesTable.getAll();
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, exercises);


                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String spinnerString = null;
                                spinnerString = spinner.getSelectedItem().toString();
                                int nPos = spinner.getSelectedItemPosition();


                                Toast.makeText(getApplicationContext(), "getSelectedItem=" + spinnerString,
                                        Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), "getSelectedItemPosition=" + nPos,
                                        Toast.LENGTH_LONG).show();

                                String newEntry = editText.getText().toString();
                                String newEntry2 = editText2.getText().toString();

                                Intent intent = new Intent(v.getContext(), HistoryActivity.class);
                                intent.putExtra("EXERCISE_ID", exercises.get(nPos).getId());


                                Date date = new Date();
                                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                                String time = formatter.format(date);






                                if (editText.length() != 0 && editText2.length() != 0) {
                                    Series s = new Series(
                                            -1,
                                            Double.parseDouble(newEntry),
                                            Integer.parseInt(newEntry2),
                                            new Date(),
                                            exercise_id,
                                            spinnerString,
                                            time
                                    );

                                    SeriesTable.insert(s);




                                    editText.setText("");
                                    editText2.setText("");
                                }


                                else
                                    {
                                    Toast.makeText(myDialog.getContext(), "You must put something in the text field!", Toast.LENGTH_LONG).show();
                                    }
                            }
                        });
                        myDialog.show();
                    }
                });
    }
}




