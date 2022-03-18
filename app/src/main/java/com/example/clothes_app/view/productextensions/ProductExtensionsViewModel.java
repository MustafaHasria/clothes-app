package com.example.clothes_app.view.productextensions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.repository.ColorRepository;

import java.util.List;

public class ProductExtensionsViewModel extends AndroidViewModel {

    //region Variables
    ColorRepository colorRepository;
    //endregion

    //region Constructor
    public ProductExtensionsViewModel(@NonNull Application application) {
        super(application);
        colorRepository = new ColorRepository(application);

    }
    //endregion
    
    //region Methods
    public void insert(Color color){
        colorRepository.insert(color);
    }

    public void update(Color color){
        colorRepository.update(color);
    }

    public void delete(Color color){
        colorRepository.delete(color);
    }

    public LiveData<List<Color>> getAllColors(){
        return colorRepository.getAllColors();
    }
    //endregion
}
