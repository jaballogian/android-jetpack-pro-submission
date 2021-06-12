package com.lacak.androidjetpackprosubmission.data;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface MainDataSource {
    LiveData<List<FilmEntity>> getAllMovies();

    LiveData<List<FilmEntity>> getAllShows();

    LiveData<FilmEntity> getDetailMovie(String title);

    LiveData<FilmEntity> getDetailShow(String title);
}
