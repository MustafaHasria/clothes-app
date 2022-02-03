package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.Tissue;

import java.util.List;

@Dao
public interface TissueDao {
    @Insert
    void insert(Tissue tissue);

    @Delete
    void delete(Tissue tissue);

    @Update
    void update(Tissue tissue);

    @Query("Select * from tissue_table order by name")
    LiveData<List<Tissue>> getAllTissues();
}
