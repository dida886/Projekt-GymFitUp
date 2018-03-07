package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    public FloatingActionButton bt1;
    public void FloatingButon(){


        bt1=findViewById(R.id.floatingActionButton1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startNewActivity = new Intent(MainActivity.this,add_exercise.class);
                startActivity(startNewActivity);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingButon();



    }
}
