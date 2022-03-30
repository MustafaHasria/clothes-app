package com.example.clothes_app.view.dashboard.productextensions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.model.entity.Tissue;
import com.example.clothes_app.repository.ColorRepository;
import com.example.clothes_app.repository.GenderRepository;
import com.example.clothes_app.repository.SizeRepository;
import com.example.clothes_app.repository.TissueRepository;

import java.util.List;

public class ProductExtensionsViewModel extends AndroidViewModel {

    //region Variables
    ColorRepository colorRepository;
    GenderRepository genderRepository;
    SizeRepository sizeRepository;
    TissueRepository tissueRepository;
    //endregion

    //region Constructor
    public ProductExtensionsViewModel(@NonNull Application application) {
        super(application);
        colorRepository = new ColorRepository(application);
        genderRepository = new GenderRepository(application);
        sizeRepository = new SizeRepository(application);
        tissueRepository = new TissueRepository(application);
    }
    //endregion

    //region Methods
    //region Color
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
    //endregion

    //region Gender
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
    //endregion

    //region Size
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

    //region Tissue

    public void insertTissue(Tissue tissue) {
        tissueRepository.insert(tissue);
    }

    public void updateTissue(Tissue tissue) {
        tissueRepository.update(tissue);
    }

    public void deleteTissue(Tissue tissue) {
        tissueRepository.delete(tissue);
    }

    public LiveData<List<Tissue>> getAllTissues() {
        return tissueRepository.getAllTissues();
    }
    //endregion

    //endregion
}
