package com.example.dmain.gymfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.dmain.gymfit.App.getContext;

public class Calculator_BMI_Activity extends AppCompatActivity {
    private EditText editText_weight;
    private EditText editText2_height;
    private TextView result;
    float bmi=0,floatWeight=0,floatHeight=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator__bmi);


        android.support.v7.widget.Toolbar mToolbar =findViewById(R.id.tool_bar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });



        editText_weight = (EditText) findViewById(R.id.editText_weight);
        editText2_height = (EditText) findViewById(R.id.editText2_height);
        result = (TextView) findViewById(R.id.result_bmi);
        Button button = (Button) findViewById(R.id.button);
        final TextView displayFloat = (TextView) findViewById(R.id.result_bmi);
        final TextView bmi_advice =(TextView) findViewById(R.id.tv_bmi_advice);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringWeight = editText_weight.getText().toString();
                String stringHeight = editText2_height.getText().toString();

                floatWeight = Float.parseFloat(stringWeight);
                floatHeight = Float.parseFloat(stringHeight);
                floatHeight = floatHeight / 100;

                bmi = (floatWeight / (floatHeight * floatHeight));

                String s = Float.toString(bmi);

                if (editText2_height.length() != 0&&  editText_weight.length()!= 0)
                {

                }

                else  {

                    Toast.makeText(getContext(), "Wszystkie pola muszą być wypełnione", Toast.LENGTH_LONG).show();
                }




                if (bmi < 18.5) {

                    TextView bmi_description = (TextView) findViewById(R.id.bmi_description);
                    bmi_description.setTextColor(0xff0000ff);
                    bmi_description.setText("Masz niedowagę");
                    bmi_advice.setText("Powinieneś przytyć");
                    displayFloat.setText(s);


                } else if (bmi > 18.5 && bmi < 24.99) {
                    TextView bmi_description = (TextView) findViewById(R.id.bmi_description);
                    bmi_description.setTextColor(0xff00ff00);
                    bmi_description.setText("Waga prawidłowa");
                    bmi_advice.setText("Gratulacje!");
                    displayFloat.setText(s);


                } else if (bmi > 24.99) {
                    TextView bmi_description = (TextView) findViewById(R.id.bmi_description);
                    bmi_description.setTextColor(0xffff0000);
                    bmi_description.setText("Masz nadwagę");
                    bmi_advice.setText("Powinieneś schudnąć");
                    displayFloat.setText(s);
                }










            }
        });






    }



}
