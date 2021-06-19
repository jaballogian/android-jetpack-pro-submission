package com.lacak.androidjetpackprosubmission.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmRoomDatabase;

import java.util.List;

public class FakeFavoriteFilmRepository {
    private FavoriteFilmDao favoriteFilmDao;
    private LocalDataSource localDataSource;

    FakeFavoriteFilmRepository(Application application) {
        FavoriteFilmRoomDatabase favoriteFilmRoomDatabase = FavoriteFilmRoomDatabase.getDatabase(application);
        favoriteFilmDao = favoriteFilmRoomDatabase.favoriteFilmDao();
        localDataSource = new LocalDataSource(favoriteFilmDao);
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
