package com.example.clothes_app.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Gender_table")
public class Gender {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    //Constructor


    public Gender(String name) {
        this.name = name;
    }

    //Setter

    public int getId() {
        return id;
    }

    //Getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
