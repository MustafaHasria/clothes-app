package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_table")
public class Account {

    //region Variables
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    //image
    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "mobile")
    private int mobile;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "gender")
    private boolean gender;

    @ColumnInfo(name = "goverment")
    private String goverment;

    @ColumnInfo(name = "id_account_type")
    private int idAccountType;
    //endregion

    //region Constructor

    public Account(String userName, String password, String picture, String email, int mobile, String country, boolean gender, String goverment, int accountTypeId) {
        this.userName = userName;
        this.password = password;
        this.picture = picture;
        this.email = email;
        this.mobile = mobile;
        this.country = country;
        this.gender = gender;
        this.goverment = goverment;
        this.idAccountType = accountTypeId;
    }

    //endregion

    //region Setters & Getters

    public String getGoverment() {
        return goverment;
    }

    public void setGoverment(String goverment) {
        this.goverment = goverment;
    }

    public int getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(int idAccountType) {
        this.idAccountType = idAccountType;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    //endregion

}
