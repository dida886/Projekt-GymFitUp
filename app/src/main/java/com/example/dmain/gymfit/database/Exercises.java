package com.example.dmain.gymfit.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dmain on 16.03.2018.
 */
@Entity
public class Exercises {



    @org.greenrobot.greendao.annotation.Id(autoincrement = true)


    private long ID_EXERCISES;
    private String NAME;
    @Generated(hash = 847968230)
    public Exercises(long ID_EXERCISES, String NAME) {
        this.ID_EXERCISES = ID_EXERCISES;
        this.NAME = NAME;
    }
    @Generated(hash = 1036063136)
    public Exercises() {
    }
    public long getID_EXERCISES() {
        return this.ID_EXERCISES;
    }
    public void setID_EXERCISES(long ID_EXERCISES) {
        this.ID_EXERCISES = ID_EXERCISES;
    }
    public String getNAME() {
        return this.NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

}

