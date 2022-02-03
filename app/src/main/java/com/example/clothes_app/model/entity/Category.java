package com.example.clothes_app.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class Category {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "id_father")
    private int idFather;

    //endregion

    //region Constructor

    public Category(String picture, String name, int idFather) {
        this.picture = picture;
        this.name = name;
        this.idFather = idFather;
    }

    //endregion

    //region Setters & Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdFather() {
        return idFather;
    }

    public void setIdFather(int idFather) {
        this.idFather = idFather;
    }

    //endregion
}
