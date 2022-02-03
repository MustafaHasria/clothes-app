package com.example.clothes_app.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.model.entity.SizeProduct;

@Dao
public interface SizeProductDao {
    @Insert
    void insert(SizeProduct sizeProduct);

    @Delete
    void delete(SizeProduct sizeProduct);

    @Update
    void update(SizeProduct sizeProduct);
}
