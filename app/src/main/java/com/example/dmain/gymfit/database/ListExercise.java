package com.example.dmain.gymfit.database;

/**
 * Created by dmain on 28.03.2018.
 */

public class ListExercise {


    private  String name;
    public boolean id;




    public ListExercise(String name) {
        this.name= name;
        this.id = id;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;

    }



    }

