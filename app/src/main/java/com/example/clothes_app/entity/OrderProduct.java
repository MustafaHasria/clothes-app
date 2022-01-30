package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_product_table")
public class OrderProduct {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_product")
    private int idProduct;

    @ColumnInfo(name = "id_order")
    private int idOrder;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "sale")
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
