package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.TissueDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Tissue;

import java.util.List;

public class TissueRepository {
    //region Variables
    TissueDao tissueDao;
    //endregion

    //region Constructor

    public TissueRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        tissueDao = clothesAppDatabase.tissueDao();
    }

    //endregion
    //region Methods
    public void insert(Tissue tissue) {
        new TissueRepository.InsertTissueTask(tissueDao).execute(tissue);
    }

    public void update(Tissue tissue) {
        new TissueRepository.UpdateTissueTask(tissueDao).execute(tissue);
    }

    public void delete(Tissue tissue) {
        new TissueRepository.DeleteTissueTask(tissueDao).execute(tissue);
    }

    public LiveData<List<Tissue>> getAllTissues() {
        return tissueDao.getAllTissues();
    }
    //endregion

    //region Async tasks
    private static class InsertTissueTask extends AsyncTask<Tissue, Void, Void> {

        //region Variables
        TissueDao tissueDao;
        //endregion

        //region Constructor

        public InsertTissueTask(TissueDao tissueDao) {
            this.tissueDao = tissueDao;
        }

        @Override
        protected Void doInBackground(Tissue... tissues) {
            tissueDao.insert(tissues[0]);
            return null;
        }

        //endregion

    }


    private static class UpdateTissueTask extends AsyncTask<Tissue, Void, Void> {

        //region Variables
        TissueDao tissueDao;
        //endregion

        //region Constructor

        public UpdateTissueTask(TissueDao tissueDao) {
            this.tissueDao = tissueDao;
        }

        @Override
        protected Void doInBackground(Tissue... tissues) {
            tissueDao.update(tissues[0]);
            return null;
        }

        //endregion

    }

    private static class DeleteTissueTask extends AsyncTask<Tissue, Void, Void> {

        //region Variables
        TissueDao tissueDao;
        //endregion

        //region Constructor

        public DeleteTissueTask(TissueDao tissueDao) {
            this.tissueDao = tissueDao;
        }

        @Override
        protected Void doInBackground(Tissue... tissues) {
            tissueDao.delete(tissues[0]);
            return null;
        }

        //endregion

    }
}




