package com.example.clothes_app.view.dashboard.products.addproduct;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.repository.SizeRepository;

import java.util.List;

public class AddAndEditProductViewModel extends AndroidViewModel {


    //region Variables


    SizeRepository sizeRepository;

    //endregion

    //region Constructor
    public AddAndEditProductViewModel(@NonNull Application application) {

        super(application);
        sizeRepository = new SizeRepository(application);
    }
    //endregion

    //region methods
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

    //endregion
}
