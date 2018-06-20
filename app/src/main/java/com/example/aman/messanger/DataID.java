package com.example.aman.messanger;

public class DataID {

    private String data;
    private int id;
     public DataID(String data,int id)
     {
         this.data=data;
         this.id=id;
         }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
