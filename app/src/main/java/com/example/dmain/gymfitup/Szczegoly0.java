package com.example.dmain.gymfitup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Szczegoly0 extends AppCompatActivity {

    GridView gridView;

    static final String[] numbers = new String[] {
            "nazwa", "ilość serii", "powtórzenia", "ciężar"
            ,"pompki", "4", "10", "mc"
            ,"podciąganie", "4", "10", "mc"
            ,"wyciskanie sztanga", "4", "10", "100 kg"
            ,"brzuszki", "4", "10", "mc"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szczegoly0);

        gridView= (GridView) findViewById(R.id.gridview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                                                Toast.makeText(getApplicationContext(),
                                                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();

                                            }
                                        }
        );

    }
}
