package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ActivityDetailBinding;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        ViewModelFactory viewModelFactory= ViewModelFactory.getInstance(this);
        DetailViewModel detailViewModel = new ViewModelProvider(this, viewModelFactory).get(DetailViewModel.class);

        FilmEntity filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);

        if(filmEntity != null){
            detailViewModel.setSelectedFilm(filmEntity.getTitle());
        }
        else {
            filmEntity = detailViewModel.getSelectedFilm();
        }

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