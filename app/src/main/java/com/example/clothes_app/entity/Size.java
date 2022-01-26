package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Size_table")
public class Size {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private int gender_id;

    //Constructor
    public Size(String name, int gender_id) {
        this.name = name;
        this.gender_id = gender_id;
    }

    //Setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Getter

    public void setName(String name) {
        this.name = name;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }
}
