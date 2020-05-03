package com.example.sportfootball.Model.StandingModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TableFootballResponse {

    @SerializedName("table")
    private ArrayList<TableItem> table;

    public void setTable(ArrayList<TableItem> table){
        this.table = table;
    }

    public ArrayList<TableItem> getTable(){
        return table;
    }

    @Override
    public String toString(){
        return
                "TableFootballResponse{" +
                        "table = '" + table + '\'' +
                        "}";
    }
}