package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.OrderProduct;

import java.util.List;

@Dao
public interface OrderProductDao {
    @Insert
    void insert(OrderProduct orderProduct);

    @Delete
    void delete(OrderProduct orderProduct);

    @Update
    void update(OrderProduct orderProduct);

    @Query("Select * from order_product_table order by id")
    LiveData<List<OrderProduct>> getAllOrderProducts();

}
