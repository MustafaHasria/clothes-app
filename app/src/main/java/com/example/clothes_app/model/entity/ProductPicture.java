package com.example.clothes_app.model.entity;


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

    @ColumnInfo(name = "color_id")
    private int colorId;

    //endregion


    //region Constructor

    public ProductPicture(String picture, int productId, int colorId) {
        this.picture = picture;
        this.productId = productId;
        this.colorId = colorId;
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

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    //endregion
}
