package com.example.clothes_app.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.clothes_app.model.dao.AccountTypeDao;
import com.example.clothes_app.model.database.ClothesAppDatabase;
import com.example.clothes_app.model.entity.AccountType;

import java.util.List;

public class AccountTypeRepository {

    //region Variables
    AccountTypeDao accountTypeDao;
    //endregion

    //region Constructor

    public AccountTypeRepository(Application application) {
        ClothesAppDatabase clothesAppDatabase = ClothesAppDatabase.getInstance(application);
        this.accountTypeDao = clothesAppDatabase.accountTypeDao();
    }

    //endregion

    //regionMethods

    public void insert(AccountType accountType) {
        new InsertAccountTypeTask(accountTypeDao).execute(accountType);
    }

    public void update(AccountType accountType) {
        new UpdateAccountTypeTask(accountTypeDao).execute(accountType);
    }

    public void delete(AccountType accountType) {
        new DeleteAccountTypeTask(accountTypeDao).execute(accountType);
    }

    public LiveData<List<AccountType>> getAllAccountTypes() {
        return accountTypeDao.getAllAccountTypes();
    }
    //endregion

    //region Async tasks
    private static class InsertAccountTypeTask extends AsyncTask<AccountType, Void, Void> {
        //region Variables
        AccountTypeDao accountTypeDao;
        //endregion

        //region Constructor

        public InsertAccountTypeTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        //endregion

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.insert(accountTypes[0]);
            return null;
        }
    }

    private static class UpdateAccountTypeTask extends AsyncTask<AccountType, Void, Void> {
        //region Variables
        AccountTypeDao accountTypeDao;
        //endregion

        //region Constructor

        public UpdateAccountTypeTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        //endregion

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.update(accountTypes[0]);
            return null;
        }
    }

    private static class DeleteAccountTypeTask extends AsyncTask<AccountType, Void, Void> {
        //region Variables
        AccountTypeDao accountTypeDao;
        //endregion

        //region Constructor

        public DeleteAccountTypeTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        //endregion

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.delete(accountTypes[0]);
            return null;
        }
    }
    //endregion
}
