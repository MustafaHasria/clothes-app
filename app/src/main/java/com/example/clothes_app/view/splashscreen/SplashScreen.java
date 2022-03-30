package com.example.clothes_app.view.splashscreen;

import static com.example.clothes_app.app.AppConst.USER;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clothes_app.model.entity.Account;
import com.example.clothes_app.view.login.LoginActivity;
import com.example.clothes_app.view.main.MainActivity;

import io.paperdb.Paper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent;
        Paper.init(this);

        Account account = Paper.book().read(USER);

        if (account == null)
            intent = new Intent(SplashScreen.this, LoginActivity.class);
        else
            intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}