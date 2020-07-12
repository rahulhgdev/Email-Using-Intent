package com.example.emailintent;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends AppCompatActivity {

    private static int Splash_Time = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent emailIntent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(emailIntent);
                finish();
            }
        }, Splash_Time);
    }
}