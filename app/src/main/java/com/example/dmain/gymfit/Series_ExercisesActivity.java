package com.example.dmain.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.util.ArrayList;
import java.util.Date;

public class Series_ExercisesActivity extends AppCompatActivity {

    int weight = 1, reps = 1, series = 1;

    Button btnAdd;
    EditText editText, editText2;
    final ArrayList<String> theList = new ArrayList<>();
    BaseAdapter listAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__new__exercise);

        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Series_ExercisesActivity.this, StoperwatchActivity.class));
            }
        });


        Intent intent = getIntent();
        final int exercise_id = intent.getIntExtra("EXERCISE_ID", -1);
        Toast.makeText(this, "EX ID " + Integer.toString(exercise_id), Toast.LENGTH_LONG).show();

        editText = findViewById(R.id.txtinput);
        editText2 = findViewById(R.id.txtinput2);
        btnAdd = findViewById(R.id.btadd);

        listView = findViewById(R.id.listv);
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
        listView.setAdapter(listAdapter);

        ArrayList<Series> series = SeriesTable.getAll(exercise_id);

        if (series.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            for (Series s : series) theList.add(s.toString());

        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newEntry = editText.getText().toString();
                String newEntry2 = editText2.getText().toString();

                if (editText.length() != 0 && editText2.length() != 0) {
                    Series s = new Series(
                            -1,
                            Double.parseDouble(newEntry),
                            Integer.parseInt(newEntry2),
                            new Date(),
                            exercise_id
                    );

                    SeriesTable.insert(s);

                    theList.add(s.toString());
                    listAdapter.notifyDataSetChanged();

                    editText.setText("");
                    editText2.setText("");
                } else {
                    Toast.makeText(Series_ExercisesActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void increaseWeight(View view) {
        weight = weight + 1;
        displayWeight(weight);
    }

    public void decreaseWeight(View view) {
        if (weight > 1) {
            weight = weight - 1;
        }
        displayWeight(weight);
    }

    private void displayWeight(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.txtinput);
        displayInteger.setText("" + number);
    }

    public void increaseReps(View view) {
        reps = reps + 1;
        displayReps(reps);
    }

    public void decreaseReps(View view) {
        if (reps > 1) {
            reps = reps - 1;
        }

        displayReps(reps);
    }

    private void displayReps(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.txtinput2);
        displayInteger.setText("" + number);
    }


}
