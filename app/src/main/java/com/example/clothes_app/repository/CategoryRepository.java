package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.CategoryDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Category;

import java.util.List;

public class CategoryRepository {
    //region Variables
    CategoryDao categoryDao;
    //endregion

    //region Constructor

    public CategoryRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        this.categoryDao = clothesAppDatabase.categoryDao();
    }

    //endregion

    //region Methods

    public void insert(Category category) {
        new InsertCategoryTask(categoryDao).execute(category);
    }

    public void update(Category category) {
        new UpdateCategoryTask(categoryDao).execute(category);
    }

    public void delete(Category category) {
        new DeleteCategoryTask(categoryDao).execute(category);
    }

    public LiveData<List<Category>> getAllCategoryProducts() {
        return categoryDao.getAllCategories();
    }
    //endregion

    //region Async tasks
    private static class InsertCategoryTask extends AsyncTask<Category, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor

        public InsertCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        //endregion

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    private static class UpdateCategoryTask extends AsyncTask<Category, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor

        public UpdateCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        //endregion

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }

    private static class DeleteCategoryTask extends AsyncTask<Category, Void, Void> {
        //region Variables
        CategoryDao categoryDao;
        //endregion

        //region Constructor

        public DeleteCategoryTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        //endregion

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }
    //endregion
}
