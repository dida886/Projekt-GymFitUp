package com.example.dmain.gymfit.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dmain on 16.03.2018.
 */

@Entity
public class Series {



    @org.greenrobot.greendao.annotation.Id(autoincrement = true)


    private long SERIES;
    private String WEIGHT;
    private String REPS;
    @Generated(hash = 637748289)
    public Series(long SERIES, String WEIGHT, String REPS) {
        this.SERIES = SERIES;
        this.WEIGHT = WEIGHT;
        this.REPS = REPS;
    }
    @Generated(hash = 1528434808)
    public Series() {
    }
    public long getSERIES() {
        return this.SERIES;
    }
    public void setSERIES(long SERIES) {
        this.SERIES = SERIES;
    }
    public String getWEIGHT() {
        return this.WEIGHT;
    }
    public void setWEIGHT(String WEIGHT) {
        this.WEIGHT = WEIGHT;
    }
    public String getREPS() {
        return this.REPS;
    }
    public void setREPS(String REPS) {
        this.REPS = REPS;
    }



}
