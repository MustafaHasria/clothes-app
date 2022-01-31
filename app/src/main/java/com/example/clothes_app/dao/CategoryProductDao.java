package com.example.clothes_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.entity.CategoryProduct;

@Dao
public interface CategoryProductDao {

    @Insert
    void insert(CategoryProduct categoryProduct);

    @Delete
    void delete(CategoryProduct categoryProduct);

    @Update
    void update(CategoryProduct categoryProduct);


}
