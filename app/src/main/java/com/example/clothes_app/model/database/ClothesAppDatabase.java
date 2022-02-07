package com.example.clothes_app.model.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.clothes_app.model.dao.AccountDao;
import com.example.clothes_app.model.dao.AccountTypeDao;
import com.example.clothes_app.model.dao.CategoryDao;
import com.example.clothes_app.model.dao.CategoryProductDao;
import com.example.clothes_app.model.dao.ColorDao;
import com.example.clothes_app.model.dao.ColorProductDao;
import com.example.clothes_app.model.dao.GenderDao;
import com.example.clothes_app.model.dao.OrderDao;
import com.example.clothes_app.model.dao.OrderProductDao;
import com.example.clothes_app.model.dao.ProductDao;
import com.example.clothes_app.model.dao.ProductPictureDao;
import com.example.clothes_app.model.dao.SizeDao;
import com.example.clothes_app.model.dao.SizeProductDao;
import com.example.clothes_app.model.dao.TissueDao;
import com.example.clothes_app.model.dao.TissueProductDao;
import com.example.clothes_app.model.entity.Account;
import com.example.clothes_app.model.entity.AccountType;
import com.example.clothes_app.model.entity.Category;
import com.example.clothes_app.model.entity.CategoryProduct;
import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.model.entity.ColorProduct;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.model.entity.Order;
import com.example.clothes_app.model.entity.OrderProduct;
import com.example.clothes_app.model.entity.Product;
import com.example.clothes_app.model.entity.ProductPicture;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.model.entity.SizeProduct;
import com.example.clothes_app.model.entity.Tissue;
import com.example.clothes_app.model.entity.TissueProduct;

@Database(entities = {
        Account.class,
        AccountType.class,
        Category.class,
        CategoryProduct.class,
        Color.class,
        ColorProduct.class,
        Gender.class,
        Order.class,
        OrderProduct.class,
        Product.class,
        ProductPicture.class,
        Size.class,
        SizeProduct.class,
        Tissue.class,
        TissueProduct.class}, version = 1)

public abstract class ClothesAppDatabase extends RoomDatabase {
    private static ClothesAppDatabase instance;

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    public static synchronized ClothesAppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ClothesAppDatabase.class,
                    "clothes_app_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    //region Dao
    public abstract AccountDao accountDao();

    public abstract AccountTypeDao accountTypeDao();

    public abstract CategoryDao categoryDao();

    public abstract CategoryProductDao categoryProductDao();

    public abstract ColorDao colorDao();

    public abstract ColorProductDao colorProductDao();

    public abstract GenderDao genderDao();

    public abstract OrderDao orderDao();

    public abstract OrderProductDao orderProductDao();

    public abstract ProductDao productDao();

    public abstract ProductPictureDao productPictureDao();

    public abstract SizeDao sizeDao();

    public abstract SizeProductDao sizeProductDao();

    public abstract TissueDao tissueDao();

    public abstract TissueProductDao tissueProductDao();
    //endregion

    //class for AsyncTask
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private AccountTypeDao accountTypeDao;
        private AccountDao accountDao;


        public PopulateDbAsyncTask(ClothesAppDatabase clothesAppDatabase) {
            accountTypeDao = clothesAppDatabase.accountTypeDao();
            accountDao = clothesAppDatabase.accountDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            accountTypeDao.insert(new AccountType("Admin"));

            accountDao.insert(new Account(
                    "admin_boss",
                    "adminboss",
                    "",
                    "hello i am mustafa",
                    "",
                    "",
                    false,
                    0));
            return null;
        }
    }

}
