package com.lacak.androidjetpackprosubmission.data.source;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

import java.util.List;

public interface MainDataSource {
    List<FilmEntity> getAllMovies();

    List<FilmEntity> getAllShows();
}
