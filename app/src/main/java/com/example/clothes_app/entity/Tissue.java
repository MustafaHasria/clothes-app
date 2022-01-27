package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TissueTable")
public class Tissue {

    //region Variables

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String madeOf;

    //endregion

    //region Constructor

    public Tissue(String name, String madeOf) {
        this.name = name;
        this.madeOf = madeOf;
    }

    //endregion

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

    public String getMadeOf() {
        return madeOf;
    }

    public void setMadeOf(String madeOf) {
        this.madeOf = madeOf;
    }


    //endregion
}
