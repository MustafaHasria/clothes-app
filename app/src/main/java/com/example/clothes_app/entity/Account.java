package com.example.clothes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Account_table")
public class Account {

    //region Variables
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    //image
    @ColumnInfo
    private String userName;

    @ColumnInfo
    private String password;

    @ColumnInfo
    private String email;

    @ColumnInfo
    private int mobile;

    @ColumnInfo
    private String picture;

    @ColumnInfo
    private String country;

    @ColumnInfo
    private boolean gender;
    //endregion

    //region Constructor
    public Account(String userName, String password, String email, int mobile, String picture, String country, boolean gender) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.picture = picture;
        this.country = country;
        this.gender = gender;
    }
    //endregion

    //region Setters & Getters

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
