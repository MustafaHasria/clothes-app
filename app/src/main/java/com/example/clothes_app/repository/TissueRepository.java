package com.example.clothes_app.repository;

import android.app.Application;

import com.example.clothes_app.model.dao.TissueDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;

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
    //TODO Complete TissueRepository


}
