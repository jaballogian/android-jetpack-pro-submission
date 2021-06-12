package com.lacak.androidjetpackprosubmission.ui.favorite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.lacak.androidjetpackprosubmission.R;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.favorite));
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.light_blue_a400)));
    }
}