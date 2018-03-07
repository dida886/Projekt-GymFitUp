package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class add_exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);


        final String[] myList = {"Wyciskanie sztangi sprzed głowy", "Przysiady ze sztangą na barkach", "Skłony w leżeniu płasko", "Uginanie ramion ze sztangą stojąc podchwytem", "Wspięcia na palce w staniu"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        ListView listView = (ListView) findViewById(R.id.add_list);

        listView.setAdapter(listAdapter);

        final ListView list = (ListView) findViewById(R.id.add_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Intent myintent= new Intent(view.getContext(),Activity_New_Exercise.class);
                    startActivityForResult(myintent,0);
                }
                if(position==1)
                {
                    Intent myintent= new Intent(view.getContext(),Activity_New_Exercise.class);
                    startActivityForResult(myintent,1);
                }

                if(position==2)
                {
                    Intent myintent= new Intent(view.getContext(),Activity_New_Exercise.class);
                    startActivityForResult(myintent,2);
                }
                if(position==3)
                {
                    Intent myintent= new Intent(view.getContext(),Activity_New_Exercise.class);
                    startActivityForResult(myintent,3);
                }
                if(position==4)
                {
                    Intent myintent= new Intent(view.getContext(),Activity_New_Exercise.class);
                    startActivityForResult(myintent,4);
                }



            }
        });
    }
}
