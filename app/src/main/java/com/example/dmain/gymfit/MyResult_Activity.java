package com.example.dmain.gymfit;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.dmain.gymfit.database.models.BodyMeasure;
import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;

import java.util.ArrayList;

public class MyResult_Activity extends AppCompatActivity {


    FloatingActionButton fab;

    final ArrayList<String> theList = new ArrayList<>();

    BaseAdapter listAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_);

        fab = findViewById(R.id.fab);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
        listView = findViewById(R.id.LV_Result);
        listView.setAdapter(listAdapter);

        ArrayList<BodyMeasure> measures = BodyMeasuresTable.getAll();
        viewItemsInList(measures);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MyResult_Activity.this,my_result_popupActivity.class));

            }
        });

    }
    private void viewItemsInList (ArrayList < BodyMeasure > measures) {
        theList.clear();
        if (measures.size() == 0) {
            showMessage("Informacja", "Brak jakichkolwiek pomiarów w bazie");
            return;
        }

        for (BodyMeasure bm : measures) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Data : ").append(bm.getDate().toString()).append("\n");
            buffer.append("Ramię : ").append(bm.getArm()).append(" cm\n");
            buffer.append("Przedramię : ").append(bm.getForearm()).append(" cm\n");
            buffer.append("Klatka : ").append(bm.getChest()).append(" cm\n");
            buffer.append("Pas : ").append(bm.getWaist()).append(" cm\n");
            buffer.append("Udo : ").append(bm.getTight()).append(" cm\n");
            buffer.append("Łydka : ").append(bm.getCalf()).append(" cm\n \n");
            theList.add(buffer.toString());
        }

        listAdapter.notifyDataSetChanged();
    }
    public void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
