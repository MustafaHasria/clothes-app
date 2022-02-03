package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void insert(Order order);

    @Delete
    void delete(Order order);

    @Update
    void update(Order order);

    @Query("Select * from order_table order by  date")
    LiveData<List<Order>> getAllOrders();
}
