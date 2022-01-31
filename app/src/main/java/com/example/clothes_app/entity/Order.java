package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "order_table")
public class Order {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "sale")
    private float sale;

    @ColumnInfo(name = "id_customer")
    private int idCustomer;

    @ColumnInfo(name = "id_repo")
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

    public int getId() {
        return id;
    }

    //region Setter & Getter
    public void setId(int id) {
        this.id = id;
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
