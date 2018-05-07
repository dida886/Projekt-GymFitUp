package com.example.dmain.gymfit.database.models;

import java.text.SimpleDateFormat;

/**
 * Created by dmain on 28.03.2018.
 */

public class ListExercise {

    private String Name;
    private String Color;
    private int Id;


    public ListExercise(int id, String name, String color) {
        this.Name = name;
        this.Id = id;
        this.Color=color;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
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

