package com.example.dmain.gymfit;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity_New_Exercise extends AppCompatActivity {


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;
    private EditText txtInput2;
    int weight = 1,reps=1,series=1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__new__exercise);


        ListView listView = (ListView) findViewById(R.id.listv);
        String[] items = {};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, arrayList);
        listView.setAdapter(adapter);
        txtInput = (EditText) findViewById(R.id.txtinput);
        txtInput2 = (EditText) findViewById(R.id.txtinput2);
        Button btAdd = (Button) findViewById(R.id.btadd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtInput.getText().toString();
                String newItem2 = txtInput2.getText().toString();
                arrayList.add(series +"  "+ newItem2 +"REPS  "+ newItem +"KG");
                adapter.notifyDataSetChanged();
                series++;

            }
        });
    }

    public void increaseWeight(View view) {
        weight = weight + 1;
        displayWeight(weight);


    }public void decreaseWeight(View view) {
        if(weight>1)
        {
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


    }public void decreaseReps(View view) {
        if(reps>1)
        {
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

