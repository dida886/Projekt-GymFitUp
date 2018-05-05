package com.example.dmain.gymfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Popup_Exercise extends AppCompatActivity{
    int  reps = 1;
    double weight = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_addexercise);



    }
    public void increaseWeight1(View view) {
        weight = weight + 0.5;
        displayWeight1(weight);
    }

    public void decreaseWeight1(View view) {
        if (weight > 1) {
            weight = weight - 0.5;
        }
        displayWeight1(weight);
    }

    private void displayWeight1(double number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.txtinput);
        displayInteger.setText("" + number);
    }

    public void increaseReps1(View view) {
        reps = reps + 1;
        displayReps1(reps);
    }

    public void decreaseReps1(View view) {
        if (reps > 1) {
            reps = reps - 1;
        }

        displayReps1(reps);
    }

    private void displayReps1(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.txtinput2);
        displayInteger.setText("" + number);
    }
}
