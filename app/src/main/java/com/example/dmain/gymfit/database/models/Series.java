package com.example.dmain.gymfit.database.models;

import java.util.Date;

/**
 * Created by dmain on 26.03.2018.
 */

public class Series {

    private int Id;
    private double Weight;
    private int Repetitions;
    private Date Date;

    private int ExerciseId;

    public Series(int id, double weight, int reptitions, Date date, int exerciseId) {
        Id = id;
        Weight = weight;
        Repetitions = reptitions;
        Date = date;
        ExerciseId = exerciseId;
    }

    public int getId() {
        return Id;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public int getRepetitions() {
        return Repetitions;
    }

    public void setRepetitions(int repetitions) {
        Repetitions = repetitions;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public int getExerciseId() {
        return ExerciseId;
    }

    public void setExerciseId(int exerciseId) {
        ExerciseId = exerciseId;
    }

    public String toString(){
        return String.valueOf(this.Id) + ".  "
                + String.valueOf(this.Weight) + " powtórzeń "
                + String.valueOf(this.Repetitions) +" Kg "
                + this.Date.toString();
    }
}
