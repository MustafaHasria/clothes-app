package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.SizeProduct;

import java.util.List;

@Dao
public interface SizeProductDao {
    @Insert
    void insert(SizeProduct sizeProduct);

    @Delete
    void delete(SizeProduct sizeProduct);

    @Update
    void update(SizeProduct sizeProduct);

    @Query("Select * from size_product_table order by id")
    LiveData<List<SizeProduct>> getAllSizeProducts();
}
