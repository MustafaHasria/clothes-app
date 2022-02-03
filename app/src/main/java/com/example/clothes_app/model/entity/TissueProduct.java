package com.example.clothes_app.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tissue_product_table")
public class TissueProduct {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_product")
    private int idProduct;

    @ColumnInfo(name = "id_tissue")
    private int idTissue;

    @ColumnInfo(name = "percentage")
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

    public void setId(int id) {
        this.id = id;
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
