package com.example.dmain.gymfit.database;

class Data {

    private  String data;
    public int id;




    public Data(int id, String name) {
        this.data= name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return data;
    }

    public void setName(String data) {
        this.data = data;
    }

    public String toString(){
        return this.data;

    }



}


