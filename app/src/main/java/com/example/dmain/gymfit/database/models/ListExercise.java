package com.example.dmain.gymfit.database.models;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dmain on 28.03.2018.
 */

public class ListExercise {

    private String Name;
    private int Color;
    private int Id;



    public ListExercise(int id, String name, int color) {
        this.Name = name;
        this.Id = id;
        this.Color=color;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        this.Color = color;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String toString() {



        return String.format(String.valueOf(this.Name));
    }






}

