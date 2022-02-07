package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.CategoryProduct;

import java.util.List;

@Dao
public interface CategoryProductDao {

    @Insert
    void insert(CategoryProduct categoryProduct);

    @Delete
    void delete(CategoryProduct categoryProduct);

    @Update
    void update(CategoryProduct categoryProduct);

    @Query("Select * from category_product_table order by id")
    LiveData<List<CategoryProduct>> getAllCategoryProducts();
}
