package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CategoryProduct")
public class CategoryProduct {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int idProduct;

    @ColumnInfo
    private int idCategory;

    //endregion

    //region Constructor

    public CategoryProduct(int idProduct, int idCategory) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }


    //endregion
}
