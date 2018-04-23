package com.example.dmain.gymfit.database;

/**
 * Created by dmain on 28.03.2018.
 */

public class ListExercise {

    private String Name;
    public int Id;

    public ListExercise(int id, String name) {
        this.Name = name;
        this.Id = id;
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
        return this.Name;

    }


}

