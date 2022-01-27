package com.example.clothes_app.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TissueProductTable")
public class TissueProduct {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int idProduct;

    @ColumnInfo
    private int idTissue;

    @ColumnInfo
    private float percentage;

    //endregion

    //region Constructor

    public TissueProduct(int idProduct, int idTissue, float percentage) {
        this.idProduct = idProduct;
        this.idTissue = idTissue;
        this.percentage = percentage;
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

    public int getIdTissue() {
        return idTissue;
    }

    public void setIdTissue(int idTissue) {
        this.idTissue = idTissue;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }


    //endregion
}
