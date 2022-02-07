package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.ColorProduct;

import java.util.List;

@Dao
public interface ColorProductDao {
    @Insert
    void insert(ColorProduct colorProduct);

    @Delete
    void delete(ColorProduct colorProduct);

    @Update
    void update(ColorProduct colorProduct);

    @Query("Select * from color_product_table order by id")
    LiveData<List<ColorProduct>> getAllColorProducts();
}
