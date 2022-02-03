package com.example.clothes_app.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_product_table")
public class CategoryProduct {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_product")
    private int idProduct;

    @ColumnInfo(name = "id_category")
    private int idCategory;

    //endregion

    //region Constructor

    public CategoryProduct(int idProduct, int idCategory) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
    }

    //endregion

    //region Setter & Getter

    public void setId(int id) {
        this.id = id;
    }

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
