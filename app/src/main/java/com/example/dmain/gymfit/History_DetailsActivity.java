package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.Serie;
import com.example.dmain.gymfit.database.Series_Table;

import java.util.ArrayList;

public class History_DetailsActivity extends AppCompatActivity {
    Series_Table myDB;
    Button btnAdd;
    EditText editText, editText2;
    final ArrayList<String> theList = new ArrayList<>();
    BaseAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history__details);


        Intent intent = getIntent();
        final int exercise_id = intent.getIntExtra("EXERCISE_ID", -1);
        Toast.makeText(this, "EX ID " + Integer.toString(exercise_id), Toast.LENGTH_LONG).show();

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);

        editText = (EditText) findViewById(R.id.txtinput);
        editText2 = (EditText) findViewById(R.id.txtinput2);
        btnAdd = (Button) findViewById(R.id.btadd);

        listView = (ListView) findViewById(R.id.listv);
        myDB = new Series_Table(this);

        ArrayList<Serie> series = myDB.getListContentsSeries(exercise_id);


        if (series.size() == 0) {
//            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();

        } else {

            for (Serie s : series) theList.add(s.toString());

            listView.setAdapter(listAdapter);

        }
    }
}
