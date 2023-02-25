package com.example.geektools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent();
            intent.setClass(Splash.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in_anim, R.anim.fade_out_anim);
            finish();
        },3000);
    }
}