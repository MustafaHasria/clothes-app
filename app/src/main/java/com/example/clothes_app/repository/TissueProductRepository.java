package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.TissueProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.TissueProduct;

import java.util.List;

public class TissueProductRepository {
    //region Variables
    TissueProductDao tissueProductDao;
    //endregion

    //region Constructor
    public TissueProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        tissueProductDao = clothesAppDatabase.tissueProductDao();
    }
    //endregion

    //region Methods

    public void insert(TissueProduct tissueProduct) {
        new TissueProductRepository.InsertTissueProductTask(tissueProductDao).execute(tissueProduct);
    }

    public void update(TissueProduct tissueProduct) {
        new TissueProductRepository.UpdateTissueProductTask(tissueProductDao).execute(tissueProduct);
    }

    public void delete(TissueProduct tissueProduct) {
        new TissueProductRepository.DeleteTissueProductTask(tissueProductDao).execute(tissueProduct);
    }

    public LiveData<List<TissueProduct>> getAllTissueProducts() {
        return tissueProductDao.getAllTissueProducts();
    }

    //endregion

    //region Async tasks
    private static class InsertTissueProductTask extends AsyncTask<TissueProduct, Void, Void> {
        //region Variables
        TissueProductDao tissueProductDao;
        //endregion

        //region Constructor

        public InsertTissueProductTask(TissueProductDao tissueProductDao) {
            this.tissueProductDao = tissueProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(TissueProduct... tissueProducts) {
            tissueProductDao.insert(tissueProducts[0]);
            return null;
        }
    }

    private static class UpdateTissueProductTask extends AsyncTask<TissueProduct, Void, Void> {
        //region Variables
        TissueProductDao tissueProductDao;
        //endregion

        //region Constructor

        public UpdateTissueProductTask(TissueProductDao tissueProductDao) {
            this.tissueProductDao = tissueProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(TissueProduct... tissueProducts) {
            tissueProductDao.update(tissueProducts[0]);
            return null;
        }
    }

    private static class DeleteTissueProductTask extends AsyncTask<TissueProduct, Void, Void> {
        //region Variables
        TissueProductDao tissueProductDao;
        //endregion

        //region Constructor

        public DeleteTissueProductTask(TissueProductDao tissueProductDao) {
            this.tissueProductDao = tissueProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(TissueProduct... tissueProducts) {
            tissueProductDao.delete(tissueProducts[0]);
            return null;
        }
    }
    //endregion
}
