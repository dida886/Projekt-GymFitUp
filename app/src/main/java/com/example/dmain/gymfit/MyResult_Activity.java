package com.example.dmain.gymfit;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.BodyMeasure;
import com.example.dmain.gymfit.database.models.HistoryListAdapter;
import com.example.dmain.gymfit.database.models.MyResultListAdapter;
import com.example.dmain.gymfit.database.models.Series;
import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;
import com.example.dmain.gymfit.database.tables.SeriesTable;

import java.util.ArrayList;

public class MyResult_Activity extends AppCompatActivity {

    int[] icon = {R.drawable.arm,
            R.drawable.forearm,
            R.drawable.chest,
            R.drawable.waist,
            R.drawable.thigh,
            R.drawable.calf,};
    FloatingActionButton fab;

    final ArrayList<String> theList = new ArrayList<>();

    BaseAdapter listAdapter;
    ListView listView;
    MyResultListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_);

        fab = findViewById(R.id.fab);

        listView = findViewById(R.id.LV_Result);

        final ArrayList<BodyMeasure> bodyMeasures = BodyMeasuresTable.getAll();
        adapter = new MyResultListAdapter(getApplicationContext(),bodyMeasures, icon);
        if (bodyMeasures.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            listView.setAdapter(adapter);

        }



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MyResult_Activity.this,my_result_popupActivity.class));

            }
        });

    }

    public void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}