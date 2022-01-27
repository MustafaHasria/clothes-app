package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ColorTable")
public class Color {

    //region Variables

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    //endregion

    //region Constructor

    public Color(String name) {
        this.name = name;
    }

    //endregion

    //region Setters & Getters

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion

}
