package com.example.dmain.gymfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Calculator_BMI extends AppCompatActivity {
    private EditText editText_weight;
    private EditText editText2_height;
    private TextView result;
    float bmi=0,floatWeight=0,floatHeight=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator__bmi);




        editText_weight = (EditText) findViewById(R.id.editText_weight);
        editText2_height = (EditText) findViewById(R.id.editText2_height);
        result = (TextView) findViewById(R.id.result_bmi);
        Button button = (Button) findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringWeight = editText_weight.getText().toString();
                String stringHeight = editText2_height.getText().toString();


                floatWeight  = Float.parseFloat(stringWeight);
                floatHeight= Float.parseFloat(stringHeight);

                bmi=floatHeight/(floatWeight*floatWeight);



            }
        });






    }



}
