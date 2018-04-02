package com.example.dmain.gymfit;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dmain.gymfit.database.Body_Circuits;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyResult_Activity extends AppCompatActivity {
    Body_Circuits myDb;
    EditText editarm, editforearm,editchest,editwaist,editthigh,editcalf;
    Button btnAddData;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_);
        myDb = new Body_Circuits(this);

        editarm = findViewById(R.id.et_arm);
        editforearm = findViewById(R.id.et_forearm);
        editchest = findViewById(R.id.et_chest);
        editwaist = findViewById(R.id.et_waist);
        editthigh = findViewById(R.id.et_thigh);
        editcalf = findViewById(R.id.et_calf);

        btnAddData = findViewById(R.id.b_add_results);
        btnviewAll = findViewById(R.id.b_histry);
        AddData();
        viewAll();

    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (editarm.length() != 0 && editforearm.length() != 0 && editchest.length() != 0 && editwaist.length() != 0 && editthigh.length() != 0 && editcalf.length() != 0 ){

                            String pattern = "dd-MM-yyyy";
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                            String date = simpleDateFormat.format(new Date());

                            boolean isInserted = myDb.insertData(
                                    editarm.getText().toString(),
                                    editforearm.getText().toString(),
                                    editchest.getText().toString(),
                                    editwaist.getText().toString(),
                                    editthigh.getText().toString(),
                                    editcalf.getText().toString(), date);

                            if (isInserted == true)
                                Toast.makeText(MyResult_Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MyResult_Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    else
                        {
                        Toast.makeText(MyResult_Activity.this, "Wszystkie pola muszą być zapełnione!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res = myDb.getAllData();
                       if(res.getCount() == 0)
                       {
                           showMessage("Błąd","Nic nie znalazłem");
                           return;
                       }
                       StringBuffer buffer = new StringBuffer();
                       while (res.moveToNext()) {

                           buffer.append("Data : "+res.getString(7)+"\n");
                           buffer.append("Ramię : "+res.getString(1)+" cm\n");
                           buffer.append("Przedramię : "+res.getString(2)+" cm\n");
                           buffer.append("Klatka : "+res.getString(3)+" cm\n");
                           buffer.append("Pas : "+res.getString(4)+" cm\n");
                           buffer.append("Udo : "+res.getString(5)+" cm\n");
                           buffer.append("Łydka : "+res.getString(6)+" cm\n \n");

                       }

                       showMessage("Historia pomiarów", buffer.toString());

                    }
                }


        );
    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}
