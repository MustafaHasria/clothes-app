package com.example.clothes_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clothes_app.model.entity.AccountType;

import java.util.List;

@Dao
public interface AccountTypeDao {
    @Insert
    void insert(AccountType accountType);

    @Delete
    void delete(AccountType accountType);

    @Update
    void update(AccountType accountType);

    @Query("Select * from account_type_table order by name")
    LiveData<List<AccountType>> getAllAccountTypes();
}
