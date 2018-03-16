package com.example.dmain.gymfit.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dmain on 16.03.2018.
 */

@Entity
public class Data {



    @org.greenrobot.greendao.annotation.Id(autoincrement = true)


    private long ID_DATA;
    private String DATA;
    @Generated(hash = 1943450987)
    public Data(long ID_DATA, String DATA) {
        this.ID_DATA = ID_DATA;
        this.DATA = DATA;
    }
    @Generated(hash = 2135787902)
    public Data() {
    }
    public long getID_DATA() {
        return this.ID_DATA;
    }
    public void setID_DATA(long ID_DATA) {
        this.ID_DATA = ID_DATA;
    }
    public String getDATA() {
        return this.DATA;
    }
    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

}
