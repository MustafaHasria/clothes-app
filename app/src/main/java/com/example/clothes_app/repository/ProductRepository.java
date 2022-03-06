package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.ProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Product;

import java.util.List;

public class ProductRepository {
    //region Variables
    ProductDao productDao;
    //endregion

    //region Constructor

    public ProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        productDao = clothesAppDatabase.productDao();
    }

    //endregion

    //region Methods
    public void insert(Product product) {
        new InsertProductTask(productDao).execute(product);
    }

    public void update(Product product) {
        new UpdateProductTask(productDao).execute(product);
    }

    public void delete(Product product) {
        new DeleteProductTask(productDao).execute(product);
    }

    public LiveData<List<Product>> getAllProducts() {
        return productDao.getAllProducts();
    }
    //endregion

    //region Async tasks
    private static class InsertProductTask extends AsyncTask<Product, Void, Void> {
        //region Variables
        ProductDao productDao;
        //endregion

        //region Constructor
        public InsertProductTask(ProductDao productDao) {
            this.productDao = productDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }


    }

    private static class UpdateProductTask extends AsyncTask<Product, Void, Void> {
        //region Variables
        ProductDao productDao;
        //endregion

        //region Constructor
        public UpdateProductTask(ProductDao productDao) {
            this.productDao = productDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Product... products) {
            productDao.update(products[0]);
            return null;
        }


    }

    private static class DeleteProductTask extends AsyncTask<Product, Void, Void> {
        //region Variables
        ProductDao productDao;
        //endregion

        //region Constructor
        public DeleteProductTask(ProductDao productDao) {
            this.productDao = productDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }


    }
    //endregion

}
