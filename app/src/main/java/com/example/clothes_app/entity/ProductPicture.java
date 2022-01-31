package com.example.clothes_app.entity;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_picture_table")
public class ProductPicture {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "product_id")
    private int productId;

    @ColumnInfo(name = "color")
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

    public void setId(int id) {
        this.id = id;
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
