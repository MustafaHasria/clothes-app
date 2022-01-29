package com.example.clothes_app.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AccountTypeTable")
public class AccountType {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    //endregion

    //region Constructor

    public AccountType(String name) {
        this.name = name;
    }

    //end region

    //region Setter & Getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //end region
}
