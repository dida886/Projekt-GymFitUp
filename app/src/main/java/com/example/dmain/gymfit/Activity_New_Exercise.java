
        package com.example.dmain.gymfit;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.Toast;


        import com.example.dmain.gymfit.database.Serie;
        import com.example.dmain.gymfit.database.Series_Table;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;

        public class Activity_New_Exercise extends AppCompatActivity {

        int weight = 1,reps=1,series=1;

        Series_Table myDB;
        Button btnAdd;
        EditText editText,editText2;
        final ArrayList<String> theList = new ArrayList<>();
        BaseAdapter listAdapter;
        ListView listView;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity__new__exercise);



            listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);

            editText = (EditText) findViewById(R.id.txtinput);
            editText2 =(EditText) findViewById(R.id.txtinput2);
            btnAdd = (Button) findViewById(R.id.btadd);

            listView = (ListView) findViewById(R.id.listv);
            myDB = new Series_Table(this);

            ArrayList<Serie> series = myDB.getListContentsSeries();

            if(series.size() == 0){
                Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();

            }else{

                for (Serie s : series) theList.add(s.toString());

                listView.setAdapter(listAdapter);

            }


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String newEntry = editText.getText().toString();
                    String newEntry2 = editText2.getText().toString();


                    String pattern = "hh:mm";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                    String date = simpleDateFormat.format(new Date());



                    if (editText.length() != 0 && editText2.length() != 0) {
                        AddData(newEntry, newEntry2, date);
                        editText.setText("");
                        editText2.setText("");


                    } else {
                        Toast.makeText(Activity_New_Exercise.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                    }

                }

            });
        }

                    public void AddData(String newEntry, String newEntry2, String date) {
                        Serie s = myDB.addDataSeries(newEntry, newEntry2, date);
                        theList.add(s.toString());


                        //refresh listy
                        listAdapter.notifyDataSetChanged();




                        /*if () {
                          Toast.makeText(Activity_New_Exercise.this, "Data Sucses", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Activity_New_Exercise.this, "Something wrong", Toast.LENGTH_LONG).show();
                        }*/
                    }


                    public void increaseWeight(View view) {
                        weight = weight + 1;
                        displayWeight(weight);


                    }

                    public void decreaseWeight(View view) {
                        if (weight > 1) {
                            weight = weight - 1;
                        }
                        displayWeight(weight);
                    }

                    private void displayWeight(int number) {
                        EditText displayInteger = (EditText) findViewById(
                                R.id.txtinput);
                        displayInteger.setText("" + number);
                    }

                    public void increaseReps(View view) {
                        reps = reps + 1;
                        displayReps(reps);


                    }

                    public void decreaseReps(View view) {
                        if (reps > 1) {
                            reps = reps - 1;
                        }

                        displayReps(reps);
                    }

                    private void displayReps(int number) {
                        EditText displayInteger = (EditText) findViewById(
                                R.id.txtinput2);
                        displayInteger.setText("" + number);
                    }




        }


