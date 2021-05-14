package com.lacak.androidjetpackprosubmission.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.ui.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIMED_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent toActivityMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                toActivityMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toActivityMain);
                finish();
            }
        },SPLASH_TIMED_OUT);
    }
}