package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SizeProductTable")
public class SizeProduct {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int idSize;

    @ColumnInfo
    private int idProduct;

    //endregion

    //region Constructor

    public SizeProduct(int id, int idSize, int idProduct) {
        this.id = id;
        this.idSize = idSize;
        this.idProduct = idProduct;
    }


    //endregion

    //region Setter & Getter

    public int getId() {
        return id;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }


    //endregion
}
