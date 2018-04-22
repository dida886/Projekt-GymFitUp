package com.example.dmain.gymfit.database;

/**
 * Created by dmain on 26.03.2018.
 */

public class Serie {

    private String id;
    private String weight;
    private String reps;
    private String time;
    private String date;

    public Serie(String id, String weight, String reps, String time,String date) {


        this.id = id;
        this.weight = weight;
        this.reps = reps;
        this.time = time;
        this.date= date;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString(){
        return this.id + ".  "+ this.weight+ " powtórzeń " + this.reps+" Kg "+"               "+ this.time;
    }
}
