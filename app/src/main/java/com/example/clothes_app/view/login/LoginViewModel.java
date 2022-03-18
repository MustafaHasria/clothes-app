package com.example.clothes_app.view.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.entity.Account;
import com.example.clothes_app.repository.AccountRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    //region Variables
    AccountRepository accountRepository;

    //endregion
    public LoginViewModel(@NonNull Application application) {

        super(application);
        accountRepository = new AccountRepository(application);
    }

    //region Methods
    public void insert(Account account) {
        accountRepository.insert(account);
    }

    public void update(Account account) {
        accountRepository.update(account);
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }

    public LiveData<List<Account>> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public LiveData<List<Account>> getUserAccount(String username, String password) {
        return accountRepository.getUserAccount(username, password);
    }
    //endregion
}
