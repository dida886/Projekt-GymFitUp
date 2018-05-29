package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.tables.ExercisesTable;

import java.util.ArrayList;

public class Add_Exercises_ListActivity extends AppCompatActivity {

    ListView mListView;
    BaseAdapter mBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        final ArrayList<ListExercise> exercises = ExercisesTable.getAll();
        mBaseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);

        mListView = findViewById(R.id.add_list);

        if (exercises.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            mListView.setAdapter(mBaseAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Series_ExercisesActivity.class);
                intent.putExtra("EXERCISE_ID", exercises.get(position).getId());
               // String ID = Integer.toString(exercises.get(position).getId());
               // Toast.makeText(Add_Exercises_ListActivity.this, "XE ID: " + ID, Toast.LENGTH_LONG).show();
                startActivityForResult(intent, position);


            }
        });
    }
}
