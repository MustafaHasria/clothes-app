package com.example.clothes_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.entity.Product;

import java.util.List;

public interface ProductDao {
    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

    @Query("Select * from product_table order by  name")
    LiveData<List<Product>> getAllProducts();
}
