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

import com.example.dmain.gymfit.database.ListExercise;
import com.example.dmain.gymfit.database.List_Exercises_Table;

import java.util.ArrayList;

public class add_exercise extends AppCompatActivity {

   List_Exercises_Table myDB;
   ListView listView;
   ArrayList theList;
   BaseAdapter baseAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);




        listView = (ListView) findViewById(R.id.add_list);
        myDB = new List_Exercises_Table(this);
        theList = new ArrayList<>();
        baseAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);



        myDB = new List_Exercises_Table(this);

        final  ArrayList<ListExercise> exercises = myDB.getListContentsList_Exercises();

        if(exercises.size() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();

        }else{

            for (ListExercise e : exercises) theList.add(e.toString());

            listView.setAdapter(baseAdapter);

        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent= new Intent(view.getContext(),Activity_New_Exercise.class);
                intent.putExtra("EXERCISE_ID", exercises.get(position).id);
                startActivityForResult(intent, position);




            }
        });
    }
}
