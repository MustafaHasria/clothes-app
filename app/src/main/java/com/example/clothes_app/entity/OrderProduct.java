package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "OrderProductTable")
public class OrderProduct {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int idProduct;

    @ColumnInfo
    private int idOrder;

    @ColumnInfo
    private int quantity;

    @ColumnInfo
    private float sale;
    //endregion

    //region Constructor

    public OrderProduct(int idProduct, int idOrder, int quantity, float sale) {
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.sale = sale;
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

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }


    //endregion
}
