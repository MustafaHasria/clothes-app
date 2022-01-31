package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "color_table")
public class Color {

    //region Variables

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
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

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion

}
