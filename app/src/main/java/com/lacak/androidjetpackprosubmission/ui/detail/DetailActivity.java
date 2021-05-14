package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        FilmEntity filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);

        activityDetailBinding.textViewTitle.setText(filmEntity.getTitle());
        activityDetailBinding.textViewGenres.setText(filmEntity.getGenres());
        activityDetailBinding.textViewYear.setText(filmEntity.getYear());
        activityDetailBinding.textViewRating.setText(filmEntity.getRating());
        activityDetailBinding.textViewDuration.setText(filmEntity.getDuration());
        activityDetailBinding.textViewOverview.setText(filmEntity.getOverview());

        int imageResource = getResources().getIdentifier(filmEntity.getImagePath(), null, getPackageName());
        activityDetailBinding.imageView.setImageDrawable(getResources().getDrawable(imageResource));
    }
}