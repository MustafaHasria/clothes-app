package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.ColorProductDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.ColorProduct;

import java.util.List;

//TODO don't forget to fill this class
public class ColorProductRepository {
    //region Variables
    ColorProductDao colorProductDao;
    //endregion

    //region Constructor

    public ColorProductRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        colorProductDao = clothesAppDatabase.colorProductDao();
    }
    //endregion

    //region Methods
    public void insert(ColorProduct colorProduct) {
        new InsertColorProductTask(colorProductDao).execute(colorProduct);
    }

    public void update(ColorProduct colorProduct) {
        new UpdateColorProductTask(colorProductDao).execute(colorProduct);
    }

    public void delete(ColorProduct colorProduct) {
        new DeleteColorProductTask(colorProductDao).execute(colorProduct);
    }

    public LiveData<List<ColorProduct>> getAllColorProducts() {
        return colorProductDao.getAllColorProducts();
    }
    //endregion

    //region Async Tasks
    private static class InsertColorProductTask extends AsyncTask<ColorProduct, Void, Void> {

        //region Variables
        ColorProductDao colorProductDao;
        //endregion

        //region Constructor

        public InsertColorProductTask(ColorProductDao colorProductDao) {
            this.colorProductDao = colorProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(ColorProduct... colorProducts) {
            colorProductDao.insert(colorProducts[0]);
            return null;
        }
    }

    private static class UpdateColorProductTask extends AsyncTask<ColorProduct, Void, Void> {

        //region Variables
        ColorProductDao colorProductDao;
        //endregion

        //region Constructor

        public UpdateColorProductTask(ColorProductDao colorProductDao) {
            this.colorProductDao = colorProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(ColorProduct... colorProducts) {
            colorProductDao.update(colorProducts[0]);
            return null;
        }
    }

    private static class DeleteColorProductTask extends AsyncTask<ColorProduct, Void, Void> {

        //region Variables
        ColorProductDao colorProductDao;
        //endregion

        //region Constructor

        public DeleteColorProductTask(ColorProductDao colorProductDao) {
            this.colorProductDao = colorProductDao;
        }

        //endregion
        @Override
        protected Void doInBackground(ColorProduct... colorProducts) {
            colorProductDao.delete(colorProducts[0]);
            return null;
        }
    }
    //endregion
}
