package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.OrderDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Order;

import java.util.List;

public class OrderRepository {
    //region Variables
    OrderDao orderDao;
    //endregion

    //region Constructor
    public OrderRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        orderDao = clothesAppDatabase.orderDao();
    }
    //endregion

    //region Methods
    public void insert(Order order) {
        new InsertOrderTask(orderDao).execute(order);
    }

    public void update(Order order) {
        new UpdateOrderTask(orderDao).execute(order);
    }

    public void delete(Order order) {
        new DeleteOrderTask(orderDao).execute(order);
    }

    public LiveData<List<Order>> getAllOrders() {
        return orderDao.getAllOrders();
    }
    //endregion

    //region Async tasks

    private static class InsertOrderTask extends AsyncTask<Order, Void, Void> {

        //region Variables
        OrderDao orderDao;
        //endregion

        //region Constructor

        public InsertOrderTask(OrderDao orderDao) {
            this.orderDao = orderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Order... orders) {
            orderDao.insert(orders[0]);
            return null;
        }
    }

    private static class UpdateOrderTask extends AsyncTask<Order, Void, Void> {

        //region Variables
        OrderDao orderDao;
        //endregion

        //region Constructor

        public UpdateOrderTask(OrderDao orderDao) {
            this.orderDao = orderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Order... orders) {
            orderDao.update(orders[0]);
            return null;
        }
    }

    private static class DeleteOrderTask extends AsyncTask<Order, Void, Void> {

        //region Variables
        OrderDao orderDao;
        //endregion

        //region Constructor

        public DeleteOrderTask(OrderDao orderDao) {
            this.orderDao = orderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Order... orders) {
            orderDao.delete(orders[0]);
            return null;
        }
    }
    //endregion
}
