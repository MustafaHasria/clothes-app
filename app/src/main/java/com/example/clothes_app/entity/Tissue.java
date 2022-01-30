package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tissue_table")
public class Tissue {

    //region Variables

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "made_of")
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
