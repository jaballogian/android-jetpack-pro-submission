package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ActivityDetailBinding;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_SHOW = "tv_show";
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        ViewModelFactory viewModelFactory= ViewModelFactory.getInstance(this, getApplication());
        DetailViewModel detailViewModel = new ViewModelProvider(this, viewModelFactory).get(DetailViewModel.class);

        FilmEntity filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);
        String filmType = getIntent().getExtras().getString(EXTRA_TYPE);

        if(filmEntity != null){
            activityDetailBinding.progressBar.setVisibility(View.VISIBLE);

            if(filmType.equals(TYPE_MOVIE)){
                detailViewModel.setSelectedMovie(filmEntity.getTitle());
                detailViewModel.getSelectedMovie().observe(this, filmEntityData -> {
                    populateData(filmEntityData);
                });
            }
            else if(filmType.equals(TYPE_SHOW)){
                detailViewModel.setSelectedShow(filmEntity.getTitle());
                detailViewModel.getSelectedShow().observe(this, filmEntityData -> {
                    populateData(filmEntityData);
                });
            }
        }
    }

    private void populateData(FilmEntity inputFilmEntity){
        activityDetailBinding.progressBar.setVisibility(View.GONE);
        activityDetailBinding.textViewTitle.setText(inputFilmEntity.getTitle());
        activityDetailBinding.textViewGenres.setText(inputFilmEntity.getGenres());
        activityDetailBinding.textViewYear.setText(inputFilmEntity.getYear());
        activityDetailBinding.textViewRating.setText(inputFilmEntity.getRating());
        activityDetailBinding.textViewDuration.setText(inputFilmEntity.getDuration());
        activityDetailBinding.textViewOverview.setText(inputFilmEntity.getOverview());

        int imageResource = getResources().getIdentifier(inputFilmEntity.getImagePath(), null, getPackageName());
        activityDetailBinding.imageView.setImageDrawable(getResources().getDrawable(imageResource));
    }
}