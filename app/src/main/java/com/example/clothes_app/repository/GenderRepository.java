package com.example.clothes_app.repository;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.GenderDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Gender;

import java.util.List;

public class GenderRepository {
    //region Variables
    GenderDao genderDao;
    //endregion

    //region Constructor

    public GenderRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        genderDao = clothesAppDatabase.genderDao();
    }

    //endregion

    //region Methods

    public void insert(Gender gender) {
        new InsertGenderTask(genderDao).execute(gender);
    }

    public void update(Gender gender) {
        new UpdateGenderTask(genderDao).execute(gender);
    }

    public void delete(Gender gender) {
        new DeleteGenderTask(genderDao).execute(gender);
    }

    public LiveData<List<Gender>> getAllGenders() {
        return genderDao.getAllGenders();
    }
    //endregion

    //region Async Tasks
    private static class InsertGenderTask extends AsyncTask<Gender, Void, Void> {
        //region Variables
        GenderDao genderDao;
        //endregion

        //region Constructor

        public InsertGenderTask(GenderDao genderDao) {
            this.genderDao = genderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Gender... genders) {
            genderDao.insert(genders[0]);
            return null;
        }
    }

    private static class UpdateGenderTask extends AsyncTask<Gender, Void, Void> {
        //region Variables
        GenderDao genderDao;
        //endregion

        //region Constructor

        public UpdateGenderTask(GenderDao genderDao) {
            this.genderDao = genderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Gender... genders) {
            genderDao.update(genders[0]);
            return null;
        }
    }

    private static class DeleteGenderTask extends AsyncTask<Gender, Void, Void> {
        //region Variables
        GenderDao genderDao;
        //endregion

        //region Constructor

        public DeleteGenderTask(GenderDao genderDao) {
            this.genderDao = genderDao;
        }

        //endregion
        @Override
        protected Void doInBackground(Gender... genders) {
            genderDao.delete(genders[0]);
            return null;
        }
    }

    //endregion

}
