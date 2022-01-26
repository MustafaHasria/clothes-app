package com.example.clothes_app.entity;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product_Pictures_table")
public class ProductPicture {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)

    private int id;
    //private  ?? picture;

    @ColumnInfo
    private int productId;

    @ColumnInfo
    private Color color;

    //Constructor
    public ProductPicture(int productId, Color color) {
        this.productId = productId;
        this.color = color;
    }

    //Setter

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    //Getter

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
