package com.example.clothes_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.entity.TissueProduct;

@Dao
public interface TissueProductDao {
    @Insert
    void insert(TissueProduct tissueProduct);

    @Delete
    void delete(TissueProduct tissueProduct);

    @Update
    void update(TissueProduct tissueProduct);
}
