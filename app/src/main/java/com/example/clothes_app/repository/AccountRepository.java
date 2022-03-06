package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.AccountDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.Account;

import java.util.List;

public class AccountRepository {

    //region Variables
    AccountDao accountDao;
    //endregion

    //region Constructor

    public AccountRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        accountDao = clothesAppDatabase.accountDao();
    }
    //endregion

    //region Methods
    public void insert(Account account){
        new InsertAccountTask(accountDao).execute(account);
    }

    public void update(Account account){
        new UpdateAccountTask(accountDao).execute(account);
    }

    public void delete(Account account) {
        new DeleteAccountTask(accountDao).execute(account);
    }

    public LiveData<List<Account>> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    public List<Account> getUserAccount(String username, String password) {
        return accountDao.getUserAccount(username, password);
    }

    //endregion

    //region Async tasks
    private static class InsertAccountTask extends AsyncTask<Account, Void, Void> {
        //region Variables
        AccountDao accountDao;
        //endregion

        //region Constructor
        public InsertAccountTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.insert(accounts[0]);
            return null;
        }
    }

    private static class UpdateAccountTask extends AsyncTask<Account, Void, Void>{
        //region Variables
        AccountDao accountDao;
        //endregion

        //region Constructor
        public UpdateAccountTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.update(accounts[0]);
            return null;
        }
    }

    private static class DeleteAccountTask extends AsyncTask<Account, Void, Void>{
        //region Variables
        AccountDao accountDao;
        //endregion

        //region Constructor
        public DeleteAccountTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }
        //endregion

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.delete(accounts[0]);
            return null;
        }
    }
    //endregion
}
