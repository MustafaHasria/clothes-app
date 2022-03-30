package com.example.clothes_app.model.entity;

import static androidx.room.ColumnInfo.BLOB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "file")
public class File {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "picture", typeAffinity = BLOB)
    private byte[] picture;
    //endregion

    //region Constructor
    public File(byte[] picture) {
        this.picture = picture;
    }
    //endregion

    //region Getters & Setters

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

    //endregion

}
