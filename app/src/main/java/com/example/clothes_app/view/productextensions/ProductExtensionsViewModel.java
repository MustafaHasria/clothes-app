package com.example.clothes_app.view.productextensions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.repository.ColorRepository;
import com.example.clothes_app.repository.GenderRepository;
import com.example.clothes_app.repository.SizeRepository;

import java.util.List;

public class ProductExtensionsViewModel extends AndroidViewModel {

    //region Variables
    ColorRepository colorRepository;
    GenderRepository genderRepository;
    SizeRepository sizeRepository;
    //endregion

    //region Constructor
    public ProductExtensionsViewModel(@NonNull Application application) {
        super(application);
        colorRepository = new ColorRepository(application);
        genderRepository = new GenderRepository(application);
        sizeRepository = new SizeRepository(application);
    }
    //endregion

    //region Methods
    public void insertColor(Color color) {
        colorRepository.insert(color);
    }

    public void updateColor(Color color) {
        colorRepository.update(color);
    }

    public void deleteColor(Color color) {
        colorRepository.delete(color);
    }

    public LiveData<List<Color>> getAllColors() {
        return colorRepository.getAllColors();
    }


    public void insertGender(Gender gender) {
        genderRepository.insert(gender);
    }

    public void updateGender(Gender gender) {
        genderRepository.update(gender);
    }

    public void deleteGender(Gender gender) {
        genderRepository.delete(gender);
    }

    public LiveData<List<Gender>> getAllGenders() {
        return genderRepository.getAllGenders();
    }

    public void insertSize(Size size) {
        sizeRepository.insert(size);
    }

    public void updateSize(Size size) {
        sizeRepository.update(size);
    }

    public void deleteSize(Size size) {
        sizeRepository.delete(size);
    }

    public LiveData<List<Size>> getAllSizes() {
        return sizeRepository.getAllSizes();
    }


    //endregion
}
