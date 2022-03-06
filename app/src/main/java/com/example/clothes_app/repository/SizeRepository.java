package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.SizeDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Size;

import java.util.List;

public class SizeRepository {

    //region Variables
    SizeDao sizeDao;
    //endregion

    //region Constructor

    public SizeRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        sizeDao = clothesAppDatabase.sizeDao();
    }
    //endregion

    //region Methods
    public void insert(Size size) {
        new SizeRepository.InsertSizeTask(sizeDao).execute(size);
    }

    public void update(Size size) {
        new SizeRepository.UpdateSizeTask(sizeDao).execute(size);
    }

    public void delete(Size size) {
        new SizeRepository.DeleteSizeTask(sizeDao).execute(size);
    }

    public LiveData<List<Size>> getAllSizes() {
        return sizeDao.getAllSizes();
    }
    //endregion

    //region Async tasks
    private static class InsertSizeTask extends AsyncTask<Size, Void, Void> {

        //region Variables
        SizeDao sizeDao;
        //endregion

        //region Constructor

        public InsertSizeTask(SizeDao sizeDao) {
            this.sizeDao = sizeDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Size... sizes) {
            sizeDao.insert(sizes[0]);
            return null;
        }
    }

    private static class UpdateSizeTask extends AsyncTask<Size, Void, Void> {

        //region Variables
        SizeDao sizeDao;
        //endregion

        //region Constructor

        public UpdateSizeTask(SizeDao sizeDao) {
            this.sizeDao = sizeDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Size... sizes) {
            sizeDao.update(sizes[0]);
            return null;
        }
    }

    private static class DeleteSizeTask extends AsyncTask<Size, Void, Void> {

        //region Variables
        SizeDao sizeDao;
        //endregion

        //region Constructor

        public DeleteSizeTask(SizeDao sizeDao) {
            this.sizeDao = sizeDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Size... sizes) {
            sizeDao.delete(sizes[0]);
            return null;
        }
    }

    // endregion
}
