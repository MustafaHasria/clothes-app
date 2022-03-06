package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.ProductPictureDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.ProductPicture;

import java.util.List;

public class ProductPictureRepository {

    //region Variables
    ProductPictureDao productPictureDao;
    //endregion

    //region Constructor

    public ProductPictureRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        productPictureDao = clothesAppDatabase.productPictureDao();
    }

    //endregion

    //region Methods
    public void insert(ProductPicture productPicture) {
        new InsertProductPictureTask(productPictureDao).execute(productPicture);
    }

    public void update(ProductPicture productPicture) {
        new UpdateProductPictureTask(productPictureDao).execute(productPicture);
    }

    public void delete(ProductPicture productPicture) {
        new DeleteProductPictureTask(productPictureDao).execute(productPicture);
    }

    public LiveData<List<ProductPicture>> getAllProductPictures() {
        return productPictureDao.getAllProductPictures();
    }
    //endregion

    //region Async tasks
    private static class InsertProductPictureTask extends AsyncTask<ProductPicture, Void, Void> {

        //region Variables
        ProductPictureDao productPictureDao;
        //endregion

        //region Constructor
        public InsertProductPictureTask(ProductPictureDao productPictureDao) {
            this.productPictureDao = productPictureDao;
        }
        //endregion

        @Override
        protected Void doInBackground(ProductPicture... productPictures) {
            productPictureDao.insert(productPictures[0]);
            return null;
        }
    }

    private static class UpdateProductPictureTask extends AsyncTask<ProductPicture, Void, Void> {

        //region Variables
        ProductPictureDao productPictureDao;
        //endregion

        //region Constructor
        public UpdateProductPictureTask(ProductPictureDao productPictureDao) {
            this.productPictureDao = productPictureDao;
        }
        //endregion

        @Override
        protected Void doInBackground(ProductPicture... productPictures) {
            productPictureDao.update(productPictures[0]);
            return null;
        }
    }

    private static class DeleteProductPictureTask extends AsyncTask<ProductPicture, Void, Void> {

        //region Variables
        ProductPictureDao productPictureDao;
        //endregion

        //region Constructor
        public DeleteProductPictureTask(ProductPictureDao productPictureDao) {
            this.productPictureDao = productPictureDao;
        }
        //endregion

        @Override
        protected Void doInBackground(ProductPicture... productPictures) {
            productPictureDao.delete(productPictures[0]);
            return null;
        }
    }
    //endregion
}
