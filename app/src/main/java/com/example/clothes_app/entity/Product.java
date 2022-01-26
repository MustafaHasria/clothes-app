package com.example.clothes_app.entity;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product_table")
public class Product {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private float price;

    @ColumnInfo
    private int pictureId;

    @ColumnInfo
    private int sizeId;

    @ColumnInfo
    private String codeQR;////?????

    @ColumnInfo
    private Color color;

    @ColumnInfo
    private boolean offer;

    @ColumnInfo
    private String description;

    @ColumnInfo
    private String typeOfTissue;

    //Constructor
    public Product(String name, float price, int pictureId, int sizeId, String codeQR, Color color, boolean offer, String description, String typeOfTissue) {
        this.name = name;
        this.price = price;
        this.pictureId = pictureId;
        this.sizeId = sizeId;
        this.codeQR = codeQR;
        this.color = color;
        this.offer = offer;
        this.description = description;
        this.typeOfTissue = typeOfTissue;
    }

    //Setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    //Getter

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTissue() {
        return typeOfTissue;
    }

    public void setTypeOfTissue(String typeOfTissue) {
        this.typeOfTissue = typeOfTissue;
    }
}
