package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.FilmEntity;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FilmEntity filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);
    }
}