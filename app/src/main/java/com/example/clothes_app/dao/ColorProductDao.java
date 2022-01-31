package com.example.clothes_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.entity.ColorProduct;

@Dao
public interface ColorProductDao {
    @Insert
    void insert(ColorProduct colorProduct);

    @Delete
    void delete(ColorProduct colorProduct);

    @Update
    void update(ColorProduct colorProduct);


}
