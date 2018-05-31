package com.example.dmain.gymfit.database.models;

import com.example.dmain.gymfit.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BodyMeasure {


    int[] icon = {R.drawable.calendar,};
    private int Id;
    private double Arm;
    private double Forearm;
    private double Chest;
    private double Waist;
    private double Tight;
    private double Calf;
    private Date Date;

    public BodyMeasure(int id, double arm, double forearm, double chest, double waist, double tight, double calf, Date date) {
        Id = id;
        Arm = arm;
        Forearm = forearm;
        Chest = chest;
        Waist = waist;
        Tight = tight;
        Calf = calf;
        Date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getArm() {
        return Arm;
    }

    public void setArm(double arm) {
        Arm = arm;
    }

    public double getForearm() {
        return Forearm;
    }

    public void setForearm(double forearm) {
        Forearm = forearm;
    }

    public double getChest() {
        return Chest;
    }

    public void setChest(double chest) {
        Chest = chest;
    }

    public double getWaist() {
        return Waist;
    }

    public void setWaist(double waist) {
        Waist = waist;
    }

    public double getTight() {
        return Tight;
    }

    public void setTight(double tight) {
        Tight = tight;
    }

    public double getCalf() {
        return Calf;
    }

    public void setCalf(double calf) {
        Calf = calf;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public int[] getIcon() {
        return icon;
    }

    public void setIcon(int[] icon) {
        this.icon = icon;
    }

    public String myDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


        return String.format(formatter.format(this.Date));

    }
}
