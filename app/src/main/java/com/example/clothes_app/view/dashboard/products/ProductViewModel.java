package com.example.clothes_app.view.dashboard.products;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Product;
import com.example.clothes_app.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    //region Variables
    ProductRepository productRepository;
    //endregion

    //region Constructor
    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
    }
    //endregion

    //region Methods
    public void insert(Product product) {
        productRepository.insert(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public LiveData<List<Product>> getAllProducts() {
        return productRepository.getAllProducts();
    }
    //endregion
}
