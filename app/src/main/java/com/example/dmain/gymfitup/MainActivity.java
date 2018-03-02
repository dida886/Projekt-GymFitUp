package com.example.dmain.gymfitup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final String[] myList = {"piątek, 22 grudnia 2017", "sobota, 23 grudnia 2017", "niedziela, 24 grudnia 2017", "poniedziałek, 25 grudnia 2017", "wtorek, 26 grudnia 2017"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        ListView listView = (ListView) findViewById(R.id.mojalista);

        listView.setAdapter(listAdapter);

        final ListView list = (ListView) findViewById(R.id.mojalista);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Intent myintent= new Intent(view.getContext(),Szczegoly0.class);
                    startActivityForResult(myintent,0);
                }
                if(position==1)
                {
                    Intent myintent= new Intent(view.getContext(),Szczegoly1.class);
                    startActivityForResult(myintent,1);
                }

                if(position==2)
                {
                    Intent myintent= new Intent(view.getContext(),Szczegoly2.class);
                    startActivityForResult(myintent,2);
                }
                if(position==3)
                {
                    Intent myintent= new Intent(view.getContext(),Szczegoly3.class);
                    startActivityForResult(myintent,3);
                }
                if(position==4)
                {
                    Intent myintent= new Intent(view.getContext(),Szczegoly4.class);
                    startActivityForResult(myintent,4);
                }



            }
        });


    }
}
