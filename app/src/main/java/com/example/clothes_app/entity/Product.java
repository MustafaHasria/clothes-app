package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class Product {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price_dollar")
    private float priceDollar;

    @ColumnInfo(name = "code_qr")
    private String codeQR;

    @ColumnInfo(name = "is_offered")
    private boolean isOffered;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "type_of_tissue")
    private String typeOfTissue;

    @ColumnInfo(name = "collection_season")
    private String collectionSeason;

    @ColumnInfo(name = "id_color_product")
    private int idColorProduct;

    @ColumnInfo(name = "id_size_product")
    private int idSizeProduct;

    @ColumnInfo(name = "id_category_product")
    private int idCategoryProduct;

    //endregion


    //region Constructor

    public Product(String name, float priceDollar, String codeQR, boolean isOffered, String description, String typeOfTissue, String collectionSeason, int idColorProduct, int idSizeProduct, int idCategoryProduct) {
        this.name = name;
        this.priceDollar = priceDollar;
        this.codeQR = codeQR;
        this.isOffered = isOffered;
        this.description = description;
        this.typeOfTissue = typeOfTissue;
        this.collectionSeason = collectionSeason;
        this.idColorProduct = idColorProduct;
        this.idSizeProduct = idSizeProduct;
        this.idCategoryProduct = idCategoryProduct;
    }

    //endregion

    //region Setter & Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPriceDollar() {
        return priceDollar;
    }

    public void setPriceDollar(float priceDollar) {
        this.priceDollar = priceDollar;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTissue() {
        return typeOfTissue;
    }

    public void setTypeOfTissue(String typeOfTissue) {
        this.typeOfTissue = typeOfTissue;
    }

    public String getCollectionSeason() {
        return collectionSeason;
    }

    public void setCollectionSeason(String collectionSeason) {
        this.collectionSeason = collectionSeason;
    }

    public int getIdColorProduct() {
        return idColorProduct;
    }

    public void setIdColorProduct(int idColorProduct) {
        this.idColorProduct = idColorProduct;
    }

    public int getIdSizeProduct() {
        return idSizeProduct;
    }

    public void setIdSizeProduct(int idSizeProduct) {
        this.idSizeProduct = idSizeProduct;
    }

    public int getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(int idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }


    //endregion
}
