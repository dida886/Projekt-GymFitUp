package com.example.dmain.gymfit.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dmain on 29.03.2018.
 */

public class Training {
    Training_Table myDB;
    String id;
    final ArrayList<String> theList = new ArrayList<>();


    String x = "yy:mm:dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(x);

    String data = simpleDateFormat.format(new Date());







    public Training(String itemData) {

        this.data=data;
        this.id=id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
