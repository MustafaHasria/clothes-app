package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.Size;

import java.util.List;

@Dao
public interface SizeDao {
    @Insert
    void insert(Size size);

    @Delete
    void delete(Size size);

    @Update
    void update(Size size);

    @Query("Select * from size_table order by    name")
    LiveData<List<Size>> getAllSizes();
}
