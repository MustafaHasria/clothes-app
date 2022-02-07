package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.OrderProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.OrderProduct;

import java.util.List;

public class OrderProductRepository {
    //region Variables
    OrderProductDao orderProductDao;
    //endregion

    //region Constructor
    public OrderProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        orderProductDao = clothesAppDatabase.orderProductDao();
    }
    //endregion

    //region Methods

    public void insert(OrderProduct orderProduct) {
        new InsertOrderProductTask(orderProductDao).execute(orderProduct);
    }

    public void update(OrderProduct orderProduct) {
        new UpdateOrderProductTask(orderProductDao).execute(orderProduct);
    }

    public void delete(OrderProduct orderProduct) {
        new DeleteOrderProductTask(orderProductDao).execute(orderProduct);
    }

    public LiveData<List<OrderProduct>> getAllOrderProducts() {
        return orderProductDao.getAllOrderProducts();
    }

    //endregion

    //region Async tasks
    private static class InsertOrderProductTask extends AsyncTask<OrderProduct, Void, Void> {
        //region Variables
        OrderProductDao orderProductDao;
        //endregion

        //region Constructor

        public InsertOrderProductTask(OrderProductDao orderProductDao) {
            this.orderProductDao = orderProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(OrderProduct... orderProducts) {
            orderProductDao.insert(orderProducts[0]);
            return null;
        }
    }

    private static class UpdateOrderProductTask extends AsyncTask<OrderProduct, Void, Void> {
        //region Variables
        OrderProductDao orderProductDao;
        //endregion

        //region Constructor

        public UpdateOrderProductTask(OrderProductDao orderProductDao) {
            this.orderProductDao = orderProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(OrderProduct... orderProducts) {
            orderProductDao.update(orderProducts[0]);
            return null;
        }
    }

    private static class DeleteOrderProductTask extends AsyncTask<OrderProduct, Void, Void> {
        //region Variables
        OrderProductDao orderProductDao;
        //endregion

        //region Constructor

        public DeleteOrderProductTask(OrderProductDao orderProductDao) {
            this.orderProductDao = orderProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(OrderProduct... orderProducts) {
            orderProductDao.delete(orderProducts[0]);
            return null;
        }
    }
    //endregion
}
