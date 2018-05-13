package com.example.dmain.gymfit.database.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmain on 26.03.2018.
 */

public class Series {

    private int Id;
    private double Weight;
    private int Repetitions;
    private Date Date;
    private String ExercisesName;
    private Date Time2;
    private int ColorID;

    private int ExerciseId;

    public Series(int id, double weight, int reptitions, Date date, int exerciseId, String exercisesName, Date time, int colorID) {



        Id = id;
        Weight = weight;
        Repetitions = reptitions;
        Date = date;
        ExerciseId = exerciseId;
        ExercisesName = exercisesName;
        Time2 = time;
        ColorID= colorID;


    }


    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int colorID) {
        ColorID = colorID;
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

    public String getExercisesName() {
        return ExercisesName;
    }

    public void setExercisesName(String exercisesName) {
        ExercisesName = exercisesName;
    }

    public Date getTime2() {
        return Time2;
    }

    public void setTime2(Date time) {
        Time2 = time;
    }


    public String getMyTime(){

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return String.format(formatter.format(this.Date));

    }


    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return String.format(String.format(String.valueOf(this.Id) + ".  "
                + String.valueOf(this.ExercisesName)
                + String.valueOf(this.Weight) + " Kg "
                + String.valueOf(this.Repetitions) + " powtórzeń "
                + String.valueOf(this.Time2)
                + formatter.format(this.Date)));
    }


}
