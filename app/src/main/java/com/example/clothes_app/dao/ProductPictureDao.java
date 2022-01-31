package com.example.clothes_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.entity.ProductPicture;

@Dao
public interface ProductPictureDao {
    @Insert
    void insert(ProductPicture productPicture);

    @Delete
    void delete(ProductPicture productPicture);

    @Update
    void update(ProductPicture productPicture);
}
