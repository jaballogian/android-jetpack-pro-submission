package com.lacak.androidjetpackprosubmission.ui.favoritedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ActivityFavoriteDetailBinding;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

public class FavoriteDetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_SHOW = "show";
    private ActivityFavoriteDetailBinding activityFavoriteDetailBinding;
    private FavoriteDetailViewModel favoriteDetailViewModel;
    private FilmEntity filmEntity;

    public static final String EXTRA_FAVORITE_FILM = "extra_favorite_film";
    public static final int REQUEST_DELETE = 200;
    public static final int RESULT_DELETE = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFavoriteDetailBinding = ActivityFavoriteDetailBinding.inflate(getLayoutInflater());
        setContentView(activityFavoriteDetailBinding.getRoot());

        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(this, getApplication());
        favoriteDetailViewModel = new ViewModelProvider(this, viewModelFactory).get(FavoriteDetailViewModel.class);

        filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);

        if(filmEntity != null) {
            activityFavoriteDetailBinding.progressBar.setVisibility(View.VISIBLE);

            if(filmEntity.getType().equals(TYPE_MOVIE)) {
                favoriteDetailViewModel.setSelectedFavoriteMovie(filmEntity.getId());
                favoriteDetailViewModel.getSelectedFavoriteMovie().observe(this, filmEntityData -> {
                    populateData(filmEntityData);
                });
            }
            else if(filmEntity.getType().equals(TYPE_SHOW)) {
                favoriteDetailViewModel.setSelectedFavoriteShow(filmEntity.getId());
                favoriteDetailViewModel.getSelectedFavoriteShow().observe(this, filmEntityData -> {
                   populateData(filmEntityData);
                });
            }
        }
    }

    private void populateData(FilmEntity inputFilmEntity) {
        activityFavoriteDetailBinding.progressBar.setVisibility(View.GONE);
        activityFavoriteDetailBinding.textViewTitle.setText(inputFilmEntity.getTitle());
        activityFavoriteDetailBinding.textViewGenres.setText(inputFilmEntity.getGenres());
        activityFavoriteDetailBinding.textViewYear.setText(inputFilmEntity.getYear());
        activityFavoriteDetailBinding.textViewRating.setText(inputFilmEntity.getRating());
        activityFavoriteDetailBinding.textViewDuration.setText(inputFilmEntity.getDuration());
        activityFavoriteDetailBinding.textViewOverview.setText(inputFilmEntity.getOverview());

        int imageResource = getResources().getIdentifier(inputFilmEntity.getImagePath(), null, getPackageName());
        activityFavoriteDetailBinding.imageView.setImageDrawable(getResources().getDrawable(imageResource));
    }
}