package com.example.dmain.gymfit;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.BodyMeasure;
import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyResult_Activity extends AppCompatActivity {

    EditText editarm, editforearm, editchest, editwaist, editthigh, editcalf;
    Button btnAddData;
    final ArrayList<String> theList = new ArrayList<>();

    BaseAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_);

        editarm = findViewById(R.id.et_arm);
        editforearm = findViewById(R.id.et_forearm);
        editchest = findViewById(R.id.et_chest);
        editwaist = findViewById(R.id.et_waist);
        editthigh = findViewById(R.id.et_thigh);
        editcalf = findViewById(R.id.et_calf);
        btnAddData = findViewById(R.id.b_add_results);

        AddData();

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
        listView = findViewById(R.id.LV_Result);
        listView.setAdapter(listAdapter);

        ArrayList<BodyMeasure> measures = BodyMeasuresTable.getAll();
        viewItemsInList(measures);
    }

    private void viewItemsInList(ArrayList<BodyMeasure> measures) {
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

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
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

                            if (id > 0)
                                Toast.makeText(MyResult_Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MyResult_Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                            ArrayList<BodyMeasure> measures = BodyMeasuresTable.getAll();
                            viewItemsInList(measures);
                        } else {
                            Toast.makeText(MyResult_Activity.this, "Wszystkie pola muszą być zapełnione!", Toast.LENGTH_LONG).show();
                        }
                    }


                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}
