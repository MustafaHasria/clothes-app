package com.example.clothes_app.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.clothes_app.dao.AccountDao;
import com.example.clothes_app.dao.AccountTypeDao;
import com.example.clothes_app.dao.CategoryDao;
import com.example.clothes_app.dao.CategoryProductDao;
import com.example.clothes_app.dao.ColorDao;
import com.example.clothes_app.dao.ColorProductDao;
import com.example.clothes_app.dao.GenderDao;
import com.example.clothes_app.dao.OrderDao;
import com.example.clothes_app.dao.OrderProductDao;
import com.example.clothes_app.dao.ProductDao;
import com.example.clothes_app.dao.ProductPictureDao;
import com.example.clothes_app.dao.SizeDao;
import com.example.clothes_app.dao.SizeProductDao;
import com.example.clothes_app.dao.TissueDao;
import com.example.clothes_app.dao.TissueProductDao;
import com.example.clothes_app.entity.Account;
import com.example.clothes_app.entity.AccountType;
import com.example.clothes_app.entity.Category;
import com.example.clothes_app.entity.CategoryProduct;
import com.example.clothes_app.entity.Color;
import com.example.clothes_app.entity.ColorProduct;
import com.example.clothes_app.entity.Gender;
import com.example.clothes_app.entity.Order;
import com.example.clothes_app.entity.OrderProduct;
import com.example.clothes_app.entity.Product;
import com.example.clothes_app.entity.ProductPicture;
import com.example.clothes_app.entity.Size;
import com.example.clothes_app.entity.SizeProduct;
import com.example.clothes_app.entity.Tissue;
import com.example.clothes_app.entity.TissueProduct;

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

    //class for AsynTask
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private AccountTypeDao accountTypeDao;
        private AccountDao accountDao;


        public PopulateDbAsyncTask(ClothesAppDatabase clothesAppDatabase) {
            accountTypeDao = clothesAppDatabase.accountTypeDao();
            accountDao = clothesAppDatabase.accountDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            accountTypeDao.insert(new AccountType(0, "Admin"));

            accountDao.insert(new Account(
                    0,
                    "admin_boss",
                    "adminboss",
                    "",
                    "",
                    "",
                    "",
                    false,
                    "",
                    0));
            return null;
        }
    }

}
