package com.example.clothes_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(Category category);

    @Delete
    void delete(Category category);

    @Update
    void update(Category category);

    @Query("Select * from category_table order by name")
    LiveData<List<Category>> getAllCategories();
}
