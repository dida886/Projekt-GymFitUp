package com.example.dmain.gymfit;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.dmain.gymfit.Adapters.HistoryListAdapter;
import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.ExercisesTable;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    double weight = 1;
    int reps = 1;
    HistoryListAdapter mainAdapter;
    ListView mListView;


    TextView textCalendar;
    Calendar calendar;
    FloatingActionButton addbtn;
    Dialog myDialog;


    int day, month, year;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);


        android.support.v7.widget.Toolbar mToolbar =findViewById(R.id.tool_bar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });








        final int[] Icon = {R.drawable.weight,
                R.drawable.hantle};


        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.popup_addexercise);

        addbtn = findViewById(R.id.btnADD);

        textCalendar = findViewById(R.id.textDate);

        calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        month = month + 1;

        textCalendar.setText(day + "." + month + "." + year);


        textCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(HistoryActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfWeek) {
                        month = month + 1;
                        textCalendar.setText(dayOfWeek + "." + month + "." + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        mListView = findViewById(R.id.datelist);


        final ArrayList<Series> series = SeriesTable.getAll2();
        final ArrayList<ListExercise> exercises = ExercisesTable.getAll();
        mainAdapter = new HistoryListAdapter(getApplicationContext(), series, exercises, Icon);
        mainAdapter.notifyDataSetChanged();

        if (series.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();


        } else {
            mListView.setAdapter(mainAdapter);
            mainAdapter.notifyDataSetChanged();


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


                android.support.v7.widget.Toolbar mToolbar =myDialog.findViewById(R.id.tool_bar);
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                        finish();
                    }
                });

                final TextView txtweight, txtreps;
                txtweight = myDialog.findViewById(R.id.txtinput);
                txtreps = myDialog.findViewById(R.id.txtinput2);


                final Button repsplus, repsminus, weightplus, weightminus;

                repsplus = myDialog.findViewById(R.id.IncreaseReps);
                repsminus = myDialog.findViewById(R.id.DecreaseReps);
                weightminus = myDialog.findViewById(R.id.DecreaseWeight);
                weightplus = myDialog.findViewById(R.id.IncreaseWeight);

                repsplus.setOnClickListener(new View.OnClickListener() {


                    public int getReps() {
                        reps= reps+1;
                        return reps;
                    }
                    @Override
                    public void onClick(View v) {

                        txtreps.setText(""+ getReps());

                    }
                });
                repsminus.setOnClickListener(new View.OnClickListener() {



                    public int getNumber() {
                        if (reps > 1) {
                            reps = reps - 1;
                        }
                        return reps;
                    }
                    @Override
                    public void onClick(View v) {
                        txtreps.setText(""+getNumber());

                    }
                });
                weightminus.setOnClickListener(new View.OnClickListener() {



                    public double getNumber() {
                        if (weight > 1) {
                            weight = weight - 0.5;
                        }
                        return weight;
                    }
                    @Override
                    public void onClick(View v) {
                        txtweight.setText(""+getNumber());

                    }
                });
                weightplus.setOnClickListener(new View.OnClickListener() {



                    public double getNumber() {
                        weight= weight+0.5;
                        return weight;
                    }
                    @Override
                    public void onClick(View v) {
                        txtweight.setText(""+getNumber());


                    }
                });






                Button btnAdd;


                final ArrayAdapter adapter;


                final EditText editText, editText2;


                Intent intent1 = new Intent();

                final int exercise_id = intent1.getIntExtra("EXERCISE_ID", -1);


                editText = myDialog.findViewById(R.id.txtinput);
                editText2 = myDialog.findViewById(R.id.txtinput2);
                btnAdd = myDialog.findViewById(R.id.btadd);


                /*repsplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (weight > 1) {
                            weight = weight - 0.5;
                        }
                        editText.setText((int) weight);


                    }
                });
*/

                //SPINER
                final Spinner spinner = myDialog.findViewById(R.id.spinner);

                final ArrayList<ListExercise> exercises = ExercisesTable.getAll();
                final ArrayList<String> theList = new ArrayList<>();
                for (ListExercise e : exercises) theList.add(e.toString());

                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, theList);
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

                        if (editText.length() != 0 && editText2.length() != 0) {
                            Series s = new Series(
                                    -1,
                                    Double.parseDouble(newEntry),
                                    Integer.parseInt(newEntry2),
                                    new Date(),
                                    exercise_id,
                                    spinnerString,
                                    new Date(),
                                    nPos


                            );
                            SeriesTable.insert(s);
                            editText.setText("");
                            editText2.setText("");
                            Intent refresh = new Intent(getApplicationContext(), HistoryActivity.class);
                            startActivity(refresh);//Start the same Activity
                            finish(); //finish Activity.


                        } else {
                            Toast.makeText(myDialog.getContext(), "You must put something in the text field!", Toast.LENGTH_LONG).show();
                        }

                    }

                });




                myDialog.show();
            }
        });
    }



}