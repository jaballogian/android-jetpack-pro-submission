package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ActivityDetailBinding;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_FILM = "extra_film";
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_SHOW = "show";
    private ActivityDetailBinding activityDetailBinding;
    private DetailViewModel detailViewModel;
    private FilmEntity filmEntity;

    public static final String EXTRA_FAVORITE_FILM = "extra_favorite_film";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        ViewModelFactory viewModelFactory= ViewModelFactory.getInstance(this, getApplication());
        detailViewModel = new ViewModelProvider(this, viewModelFactory).get(DetailViewModel.class);

        filmEntity = getIntent().getParcelableExtra(EXTRA_FILM);

        if(filmEntity != null){
            activityDetailBinding.progressBar.setVisibility(View.VISIBLE);
            activityDetailBinding.floatingActionButtonFavorite.setVisibility(View.GONE);

            if(filmEntity.getType().equals(TYPE_MOVIE)){
                detailViewModel.setSelectedMovie(filmEntity.getTitle());
                detailViewModel.getSelectedMovie().observe(this, filmEntityData -> {
                    populateData(filmEntityData);
                });
            }
            else if(filmEntity.getType().equals(TYPE_SHOW)){
                detailViewModel.setSelectedShow(filmEntity.getTitle());
                detailViewModel.getSelectedShow().observe(this, filmEntityData -> {
                    populateData(filmEntityData);
                });
            }
        }

        activityDetailBinding.floatingActionButtonFavorite.setOnClickListener(this);
    }

    private void populateData(FilmEntity inputFilmEntity){
        activityDetailBinding.progressBar.setVisibility(View.GONE);
        activityDetailBinding.floatingActionButtonFavorite.setVisibility(View.VISIBLE);
        activityDetailBinding.textViewTitle.setText(inputFilmEntity.getTitle());
        activityDetailBinding.textViewGenres.setText(inputFilmEntity.getGenres());
        activityDetailBinding.textViewYear.setText(inputFilmEntity.getYear());
        activityDetailBinding.textViewRating.setText(inputFilmEntity.getRating());
        activityDetailBinding.textViewDuration.setText(inputFilmEntity.getDuration());
        activityDetailBinding.textViewOverview.setText(inputFilmEntity.getOverview());

        int imageResource = getResources().getIdentifier(inputFilmEntity.getImagePath(), null, getPackageName());
        activityDetailBinding.imageView.setImageDrawable(getResources().getDrawable(imageResource));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.floating_action_button_favorite) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_FAVORITE_FILM, filmEntity);
            detailViewModel.insertFavoriteFilm(filmEntity);
            setResult(RESULT_ADD, intent);
            finish();
        }
    }
}