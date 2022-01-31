package com.example.clothes_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.entity.Gender;

import java.util.List;

@Dao
public interface GenderDao {
    @Insert
    void insert(Gender gender);

    @Delete
    void delete(Gender gender);

    @Update
    void update(Gender gender);

    @Query("Select * from gender_table order by name")
    LiveData<List<Gender>> getAllGenders();
}
