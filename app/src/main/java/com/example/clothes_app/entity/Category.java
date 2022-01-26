package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category_table")
public class Category {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    //private ?? picture;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private int fatherId;

    public Category(String name, int fatherId) {
        this.name = name;
        this.fatherId = fatherId;
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

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }
}
