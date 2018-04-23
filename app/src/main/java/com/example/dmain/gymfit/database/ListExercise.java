package com.example.dmain.gymfit.database;

/**
 * Created by dmain on 28.03.2018.
 */

public class ListExercise {


    private  String name;
    public int id;




    public ListExercise(int id, String name) {
        this.name= name;
        this.id = id;
    }

    public int getId() {
        return id;
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

