package com.example.clothes_app.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.clothes_app.model.entity.OrderProduct;

@Dao
public interface OrderProductDao {
    @Insert
    void insert(OrderProduct orderProduct);

    @Delete
    void delete(OrderProduct orderProduct);

    @Update
    void update(OrderProduct orderProduct);

}