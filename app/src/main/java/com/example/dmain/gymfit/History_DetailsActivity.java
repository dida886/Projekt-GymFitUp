package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.util.ArrayList;

public class History_DetailsActivity extends AppCompatActivity {

    BaseAdapter mListAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history__details);

        Intent intent = getIntent();
        final int exerciseId = intent.getIntExtra("EXERCISE_ID", -1);

        Toast.makeText(this, "EX ID " + Integer.toString(exerciseId), Toast.LENGTH_LONG).show();

        final ArrayList<Series> series = SeriesTable.getAll(exerciseId);

        if (series.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            mListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, series);
            mListView = findViewById(R.id.listv);
            mListView.setAdapter(mListAdapter);
        }
    }
}
