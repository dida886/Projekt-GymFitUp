package com.example.dmain.gymfit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.DatabaseHelper;

import java.util.ArrayList;

public class Activity_New_Exercise extends AppCompatActivity {





    int weight = 1,reps=1,series=1;



    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__new__exercise);
        editText = (EditText) findViewById(R.id.txtinput);
        editText2 = (EditText) findViewById(R.id.txtinput2);
        btnAdd = (Button) findViewById(R.id.btadd);

        final ListView listView = (ListView) findViewById(R.id.listv);
        myDB = new DatabaseHelper(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(Activity_New_Exercise.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }


                String newEntry2 = editText2.getText().toString();
                if(editText2.length()!= 0){
                    AddData(newEntry2);
                    editText2.setText("");
                }else{
                    Toast.makeText(Activity_New_Exercise.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }



            }
        });
    }




    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
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

