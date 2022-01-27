package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category_table")
public class Category {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String picture;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private int fatherId;

    //endregion

    //region Constructor

    public Category(String picture, String name, int fatherId) {
        this.picture = picture;
        this.name = name;
        this.fatherId = fatherId;
    }

    //endregion

    //region Setters & Getters

    public int getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    //endregion
}
