package com.example.dmain.gymfit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Icon;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.tables.BodyMeasuresTable;
import com.example.dmain.gymfit.database.tables.ExercisesTable;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;


public class add_exercise_setting extends AppCompatActivity  {

    ListView mListView;
    Button btnAdd,btnColor;
    EditText editText;
    ListExercise listExercise;
    ArrayList theList;
    int savecolor = 0;


    ConstraintLayout myLayout;
    int DefaultColor;

    ListExercise myDB;

    BaseAdapter baseAdapter;
    ListView listView;
    ImageView tvImage1;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise_setting);

        final TextView tvName = (TextView) findViewById(R.id.result_date);


        tvImage1=  findViewById(R.id.tv_image1);
        ImageView tvImage2=  findViewById(R.id.tv_image2);
        ImageView tvImage3=  findViewById(R.id.tv_image3);


        btnAdd = findViewById(R.id.btn_add_exercise);
        editText = findViewById(R.id.etAddExercise);
        btnColor  = findViewById(R.id.btn_color);
        DefaultColor = ContextCompat.getColor(this,R.color.colorPrimary);

       editText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tvName.setText("" + editText.getText());

           }
       });









        listView = (ListView) findViewById(R.id.exercise_list_seting);
        theList = new ArrayList<>();
        baseAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
        final ArrayList<ListExercise> exercises = ExercisesTable.getAll();
        for (ListExercise e : exercises) theList.add(e.toString());
        listView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();
        if (exercises.size() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();


        } else {
            SwipeDismissListViewTouchListener touchListener =
                    new SwipeDismissListViewTouchListener(
                            listView,
                            new SwipeDismissListViewTouchListener.DismissCallbacks() {
                                @Override
                                public boolean canDismiss(int position) {
                                    return true;
                                }

                                @Override
                                public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                    for (int position : reverseSortedPositions) {

                                        exercises.remove(position);
                                        ExercisesTable.deleteItem(position);
                                        baseAdapter.notifyDataSetChanged();

                                    }

                                }
                            });
            listView.setOnTouchListener(touchListener);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();

               if (editText.length() != 0){
                   ListExercise listExercise= new ListExercise(
                           -1,
                           editText.getText().toString(),
                           savecolor




                   );
                   ExercisesTable.insert(listExercise);
                   baseAdapter.notifyDataSetChanged();
                   Intent refresh = new Intent(getApplicationContext(), add_exercise_setting.class);
                   startActivity(refresh);//Start the same Activity


               }

            }
        });



        btnColor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OpenColorPicker(false);

            }
        });
    }









    public void OpenColorPicker(boolean AlphaSupport){
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, DefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                DefaultColor = color;
                tvImage1.setColorFilter(color);

               savecolor=color;
            }
        });
        ambilWarnaDialog.show();
    }





}
