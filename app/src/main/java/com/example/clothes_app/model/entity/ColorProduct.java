package com.example.clothes_app.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "color_product_table")
public class ColorProduct {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_product")
    private int idProduct;

    @ColumnInfo(name = "id_color")
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

    public void setId(int id) {
        this.id = id;
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
