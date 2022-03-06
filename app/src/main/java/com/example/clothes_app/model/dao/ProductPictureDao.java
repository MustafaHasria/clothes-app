package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.ProductPicture;

import java.util.List;

@Dao
public interface ProductPictureDao {
    @Insert
    void insert(ProductPicture productPicture);

    @Delete
    void delete(ProductPicture productPicture);

    @Update
    void update(ProductPicture productPicture);

    @Query("Select * from product_picture_table order by  id")
    LiveData<List<ProductPicture>> getAllProductPictures();
}
