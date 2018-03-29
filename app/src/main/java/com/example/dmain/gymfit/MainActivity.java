package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

private CardView histcard, bmicard,addexcard, mapcard;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deklaracja Card

        histcard = (CardView) findViewById(R.id.histcardview);
        bmicard = (CardView)findViewById(R.id.bmicardview);
        addexcard = (CardView)findViewById(R.id.addcardview);
        mapcard = findViewById(R.id.mapcardviev);

        // Dodawanie activitów do card

        histcard.setOnClickListener(this);
        bmicard.setOnClickListener(this);
        addexcard.setOnClickListener(this);
        mapcard.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {
            case R.id.histcardview: i = new Intent(this, history_activity.class);startActivity(i); break;
            case R.id.bmicardview: i = new Intent(this, Calculator_BMI.class);startActivity(i); break;
            case R.id.addcardview: i = new Intent(this, add_exercise.class);startActivity(i); break;
            case R.id.mapcardviev: i = new Intent(this, MapsActivity.class);startActivity(i); break;
            default: break;

        }
    }
}
