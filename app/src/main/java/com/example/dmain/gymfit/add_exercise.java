package com.example.dmain.gymfit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.List_Exercises_Table;

import java.util.ArrayList;

public class add_exercise extends AppCompatActivity {

   List_Exercises_Table myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);




        final ListView listView = (ListView) findViewById(R.id.add_list);
        myDB = new List_Exercises_Table(this);
        final ArrayList<String> theList = new ArrayList<>();
        final ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);



        Cursor cursor = myDB.getListContentsList_Exercises();

        Log.d("ADD EXERCISE", "ITEMS: " + cursor.getCount());

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Baza jest pusta!",Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()){

                String item2 = cursor.getString(
                        cursor.getColumnIndex(List_Exercises_Table.COL2));


                theList.add(item2);

                listView.setAdapter(listAdapter);

            }
            cursor.close();
        }





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent= new Intent(view.getContext(),Activity_New_Exercise.class);
                startActivityForResult(intent, position);



            }
        });
    }
}
