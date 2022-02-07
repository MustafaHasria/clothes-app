package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.ColorDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Color;

import java.util.List;

public class ColorRepository {
    //region Variables
    ColorDao colorDao;
    //endregion

    //region Constructor

    public ColorRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        colorDao = clothesAppDatabase.colorDao();
    }
    //endregion

    //region Methods
    public void insert(Color color) {
        new InsertColorTask(colorDao).execute(color);
    }

    public void update(Color color) {
        new UpdateColorTask(colorDao).execute(color);
    }

    public void delete(Color color) {
        new DeleteColorTask(colorDao).execute(color);
    }

    public LiveData<List<Color>> getAllColors() {
        return colorDao.getAllColors();
    }
    //endregion

    //region Async Tasks
    private static class InsertColorTask extends AsyncTask<Color, Void, Void> {
        //region Variables
        ColorDao colorDao;
        //endregion

        //region Constructor
        public InsertColorTask(ColorDao colorDao) {
            this.colorDao = colorDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Color... colors) {
            colorDao.insert(colors[0]);
            return null;
        }
    }

    private static class UpdateColorTask extends AsyncTask<Color, Void, Void> {
        //region Variables
        ColorDao colorDao;
        //endregion

        //region Constructor
        public UpdateColorTask(ColorDao colorDao) {
            this.colorDao = colorDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Color... colors) {
            colorDao.update(colors[0]);
            return null;
        }
    }

    private static class DeleteColorTask extends AsyncTask<Color, Void, Void> {
        //region Variables
        ColorDao colorDao;
        //endregion

        //region Constructor
        public DeleteColorTask(ColorDao colorDao) {
            this.colorDao = colorDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Color... colors) {
            colorDao.delete(colors[0]);
            return null;
        }
    }


    //endregion
}
