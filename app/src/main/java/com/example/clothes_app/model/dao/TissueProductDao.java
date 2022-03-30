package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.TissueProduct;

import java.util.List;

@Dao
public interface TissueProductDao {
    @Insert
    void insert(TissueProduct tissueProduct);

    @Delete
    void delete(TissueProduct tissueProduct);

    @Update
    void update(TissueProduct tissueProduct);

    @Query("Select * from tissue_product_table order by id")
    LiveData<List<TissueProduct>> getAllTissueProducts();
}
