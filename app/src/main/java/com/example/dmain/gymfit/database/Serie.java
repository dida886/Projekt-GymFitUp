package com.example.dmain.gymfit.database;

/**
 * Created by dmain on 26.03.2018.
 */

public class Serie {

    private String Id;
    private String Weight;
    private String Reps;
    private String Time;
    private String Date;
    private String exercise_id;


    public Serie(String id, String weight, String reps, String time,String date, String exercise_id) {


        this.Id = id;
        this.Weight = weight;
        this.Reps = reps;
        this.Time = time;
        this.Date= date;
        this.exercise_id=exercise_id;


    }



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getReps() {
        return Reps;
    }

    public void setReps(String reps) {
        Reps = reps;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(String exercise_id) {
        this.exercise_id = exercise_id;
    }



    public String toString(){
        return this.Id + ".  "+ this.Weight+ " powtórzeń " + this.Reps+" Kg "+"               "+ this.Time;
    }
}
