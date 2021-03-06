package com.example.clothes_app.model.entity;

import static androidx.room.ColumnInfo.BLOB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class Category {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "picture", typeAffinity = BLOB)
    private byte[] picture;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "id_father")
    private int idFather;

    //endregion

    //region Constructor

    public Category(byte[] picture, String name, int idFather) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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
