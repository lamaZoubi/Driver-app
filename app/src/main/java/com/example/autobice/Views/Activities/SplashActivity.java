package com.example.autobice.Views.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(this, MainActivity.class);
        if (IsLoggedIn()) {
            startActivity(i);
        } else {
            i = new Intent(this,singup.class);
            startActivity(i);
        }


    }

    // TODO Handel Loggin
    private boolean IsLoggedIn() {
        return false;

    }
}
