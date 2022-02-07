package com.example.clothes_app.model.entity;

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
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "picture")
    private String picture;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "gender")
    private boolean gender;

    @ColumnInfo(name = "id_account_type")
    private int idAccountType;
    //endregion

    //region Constructor

    public Account(String username, String password, String picture, String email, String mobile, String country, boolean gender, int idAccountType) {
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.email = email;
        this.mobile = mobile;
        this.country = country;
        this.gender = gender;
        this.idAccountType = idAccountType;
    }


    //endregion

    //region Setters & Getters

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
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
