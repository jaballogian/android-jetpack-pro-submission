package com.lacak.androidjetpackprosubmission.data;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

import java.util.List;

public interface MainDataSource {
    LiveData<List<FilmEntity>> getAllMovies();

    LiveData<List<FilmEntity>> getAllShows();

    LiveData<FilmEntity> getDetailFilm(String title);
}
