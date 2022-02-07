package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.CategoryProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.CategoryProduct;

import java.util.List;

public class CategoryProductRepository {

    //region Variables
    CategoryProductDao categoryProductDao;
    //endregion

    //region Constructor

    public CategoryProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        this.categoryProductDao = clothesAppDatabase.categoryProductDao();
    }

    //endregion

    //region Methods

    public void insert(CategoryProduct categoryProduct) {
        new InsertCategoryProductTask(categoryProductDao).execute(categoryProduct);
    }

    public void update(CategoryProduct categoryProduct) {
        new UpdateCategoryProductTask(categoryProductDao).execute(categoryProduct);
    }

    public void delete(CategoryProduct categoryProduct) {
        new DeleteCategoryProductTask(categoryProductDao).execute(categoryProduct);
    }

    public LiveData<List<CategoryProduct>> getAllCategoryProducts() {
        return categoryProductDao.getAllCategoryProducts();
    }
    //endregion

    //region Async tasks
    private static class InsertCategoryProductTask extends AsyncTask<CategoryProduct, Void, Void> {
        //region Variables
        CategoryProductDao categoryProductDao;
        //endregion

        //region Constructor

        public InsertCategoryProductTask(CategoryProductDao categoryProductDao) {
            this.categoryProductDao = categoryProductDao;
        }

        @Override
        protected Void doInBackground(CategoryProduct... categoryProducts) {
            categoryProductDao.insert(categoryProducts[0]);
            return null;
        }

        //endregion

    }

    private static class UpdateCategoryProductTask extends AsyncTask<CategoryProduct, Void, Void> {
        //region Variables
        CategoryProductDao categoryProductDao;
        //endregion

        //region Constructor

        public UpdateCategoryProductTask(CategoryProductDao categoryProductDao) {
            this.categoryProductDao = categoryProductDao;
        }

        @Override
        protected Void doInBackground(CategoryProduct... categoryProducts) {
            categoryProductDao.update(categoryProducts[0]);
            return null;
        }

        //endregion

    }

    private static class DeleteCategoryProductTask extends AsyncTask<CategoryProduct, Void, Void> {
        //region Variables
        CategoryProductDao categoryProductDao;
        //endregion

        //region Constructor

        public DeleteCategoryProductTask(CategoryProductDao categoryProductDao) {
            this.categoryProductDao = categoryProductDao;
        }

        @Override
        protected Void doInBackground(CategoryProduct... categoryProducts) {
            categoryProductDao.delete(categoryProducts[0]);
            return null;
        }

        //endregion

    }

    //endregion

}
