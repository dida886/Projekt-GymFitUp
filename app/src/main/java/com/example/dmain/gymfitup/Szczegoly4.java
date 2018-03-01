package com.example.dmain.gymfitup;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Szczegoly4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szczegoly4);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] list= getResources().getStringArray(R.array.NazwaCw);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt);
        spinner.setAdapter(adapter);
    }
}
