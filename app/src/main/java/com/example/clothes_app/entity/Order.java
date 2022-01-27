package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "OrderTable")
public class Order {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private Date date;

    @ColumnInfo
    private float sale;

    @ColumnInfo
    private int idCustomer;

    @ColumnInfo
    private int idRepo;

    //endregion

    //region Constructor

    public Order(Date date, float sale, int idCustomer, int idRepo) {
        this.date = date;
        this.sale = sale;
        this.idCustomer = idCustomer;
        this.idRepo = idRepo;
    }

    //endregion

    //region Setter & Getter

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdRepo() {
        return idRepo;
    }

    public void setIdRepo(int idRepo) {
        this.idRepo = idRepo;
    }


    //endregion
}