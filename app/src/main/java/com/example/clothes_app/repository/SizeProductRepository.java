package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.SizeProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.SizeProduct;

import java.util.List;

public class SizeProductRepository {
    //region Variables
    SizeProductDao sizeProductDao;
    //endregion

    //region Constructor
    public SizeProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        sizeProductDao = clothesAppDatabase.sizeProductDao();
    }
    //endregion

    //region Methods

    public void insert(SizeProduct sizeProduct) {
        new SizeProductRepository.InsertSizeProductTask(sizeProductDao).execute(sizeProduct);
    }

    public void update(SizeProduct sizeProduct) {
        new SizeProductRepository.UpdateSizeProductTask(sizeProductDao).execute(sizeProduct);
    }

    public void delete(SizeProduct sizeProduct) {
        new SizeProductRepository.DeleteSizeProductTask(sizeProductDao).execute(sizeProduct);
    }

    public LiveData<List<SizeProduct>> getAllSizeProducts() {
        return sizeProductDao.getAllSizeProducts();
    }

    //endregion

    //region Async tasks
    private static class InsertSizeProductTask extends AsyncTask<SizeProduct, Void, Void> {
        //region Variables
        SizeProductDao sizeProductDao;
        //endregion

        //region Constructor

        public InsertSizeProductTask(SizeProductDao sizeProductDao) {
            this.sizeProductDao = sizeProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(SizeProduct... sizeProducts) {
            sizeProductDao.insert(sizeProducts[0]);
            return null;
        }
    }

    private static class UpdateSizeProductTask extends AsyncTask<SizeProduct, Void, Void> {
        //region Variables
        SizeProductDao sizeProductDao;
        //endregion

        //region Constructor

        public UpdateSizeProductTask(SizeProductDao sizeProductDao) {
            this.sizeProductDao = sizeProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(SizeProduct... sizeProducts) {
            sizeProductDao.update(sizeProducts[0]);
            return null;
        }
    }

    private static class DeleteSizeProductTask extends AsyncTask<SizeProduct, Void, Void> {
        //region Variables
        SizeProductDao sizeProductDao;
        //endregion

        //region Constructor

        public DeleteSizeProductTask(SizeProductDao sizeProductDao) {
            this.sizeProductDao = sizeProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(SizeProduct... sizeProducts) {
            sizeProductDao.delete(sizeProducts[0]);
            return null;
        }
    }
    //endregion
}
