package com.example.clothes_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.entity.Color;

import java.util.List;

@Dao
public interface ColorDao {
    @Insert
    void insert(Color color);

    @Delete
    void delete(Color color);

    @Update
    void update(Color color);

    @Query("Select * from color_table order by name")
    LiveData<List<Color>> getAllColors();
}
