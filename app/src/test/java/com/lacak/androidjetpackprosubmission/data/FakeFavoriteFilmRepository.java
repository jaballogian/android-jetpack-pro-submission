package com.lacak.androidjetpackprosubmission.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

import java.util.List;

public class FakeFavoriteFilmRepository {
    private LocalDataSource localDataSource;

    public FakeFavoriteFilmRepository(@NonNull LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    public LiveData<List<FilmEntity>> getAllFavoriteMovies() {
        return localDataSource.getAllFavoriteMovies();
    }

    public LiveData<List<FilmEntity>> getAllFavoriteShows() {
        return localDataSource.getAllFavoriteShows();
    }

    public LiveData<FilmEntity> getDetailFavoriteMovie(int id) {
        return localDataSource.getDetailFavoriteMovie(id);
    }

    public LiveData<FilmEntity> getDetailFavoriteShow(int id) {
        return localDataSource.getDetailFavoriteShow(id);
    }
}
