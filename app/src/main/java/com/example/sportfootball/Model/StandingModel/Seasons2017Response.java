package com.example.sportfootball.Model.StandingModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seasons2017Response{

    @SerializedName("table")
    private List<TableItem> table;

    public void setTable(List<TableItem> table){
        this.table = table;
    }

    public List<TableItem> getTable(){
        return table;
    }

    @Override
    public String toString(){
        return
                "Seasons2017Response{" +
                        "table = '" + table + '\'' +
                        "}";
    }
}