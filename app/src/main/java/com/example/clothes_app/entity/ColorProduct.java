package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ColorProductTable")
public class ColorProduct {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int idProduct;

    @ColumnInfo
    private int idColor;

    //endregion

    //region Constructor

    public ColorProduct(int idProduct, int idColor) {
        this.idProduct = idProduct;
        this.idColor = idColor;
    }

    //endregion

    //region Setter & Getter

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }


    //endregion
}
