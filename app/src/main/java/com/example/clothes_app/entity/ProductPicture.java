package com.example.clothes_app.entity;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProductPictureTable")
public class ProductPicture {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String picture;

    @ColumnInfo
    private int productId;

    @ColumnInfo
    private Color color;

    //endregion


    //region Constructor

    public ProductPicture(String picture, int productId, Color color) {
        this.picture = picture;
        this.productId = productId;
        this.color = color;
    }

    //endregion

    //region Setter & Getters

    public int getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //endregion
}
