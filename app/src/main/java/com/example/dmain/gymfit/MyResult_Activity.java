package com.example.dmain.gymfit;


import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.BodyMeasure;
import com.example.dmain.gymfit.Adapters.MyResultListAdapter;
import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;

import java.util.ArrayList;
import java.util.Date;

public class MyResult_Activity extends AppCompatActivity {


    int[] icon = {R.drawable.arm,
            R.drawable.forearm,
            R.drawable.chest,
            R.drawable.waist,
            R.drawable.thigh,
            R.drawable.calf,};
    FloatingActionButton fab;

    Dialog myDialog;

    final ArrayList<String> theList = new ArrayList<>();

    BaseAdapter listAdapter;
    ListView listView;
    MyResultListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_);
        android.support.v7.widget.Toolbar mToolbar = findViewById(R.id.tool_bar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_my_result_popup);

        fab = findViewById(R.id.fab);

        listView = findViewById(R.id.LV_Result);

        final ArrayList<BodyMeasure> bodyMeasures = BodyMeasuresTable.getAll();
        adapter = new MyResultListAdapter(getApplicationContext(), bodyMeasures, icon);
        if (bodyMeasures.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            listView.setAdapter(adapter);

        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.activity_my_result_popup);


                final EditText editarm, editforearm, editchest, editwaist, editthigh, editcalf;
                Button btnAddData;





                android.support.v7.widget.Toolbar mToolbar = myDialog.findViewById(R.id.tool_bar);
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), MyResult_Activity.class));
                        finish();
                    }
                });




                editarm = myDialog.findViewById(R.id.et_arm2);
                editforearm = myDialog.findViewById(R.id.et_forearm2);
                editchest = myDialog.findViewById(R.id.et_chest2);
                editwaist = myDialog.findViewById(R.id.et_waist2);
                editthigh = myDialog.findViewById(R.id.et_thigh2);
                editcalf = myDialog.findViewById(R.id.et_calf);
                btnAddData = myDialog.findViewById(R.id.b_add_results2);


                btnAddData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (editarm.length() != 0 && editforearm.length() != 0 && editchest.length() != 0 && editwaist.length() != 0 && editthigh.length() != 0 && editcalf.length() != 0) {
                            int id = BodyMeasuresTable.insert(
                                    new BodyMeasure(
                                            -1,
                                            Double.parseDouble(editarm.getText().toString()),
                                            Double.parseDouble(editforearm.getText().toString()),
                                            Double.parseDouble(editchest.getText().toString()),
                                            Double.parseDouble(editwaist.getText().toString()),
                                            Double.parseDouble(editthigh.getText().toString()),
                                            Double.parseDouble(editcalf.getText().toString()),
                                            new Date()
                                    )
                            );


                        } else {
                            Toast.makeText(myDialog.getContext(), "Wszystkie pola muszą być zapełnione!", Toast.LENGTH_LONG).show();
                        }
                    }


                });
                myDialog.show();
            }
        });
    }
}


