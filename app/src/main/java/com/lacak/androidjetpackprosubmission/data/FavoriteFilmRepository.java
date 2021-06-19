package com.lacak.androidjetpackprosubmission.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmRoomDatabase;

import java.util.List;

public class FavoriteFilmRepository {
    private FavoriteFilmDao favoriteFilmDao;
    private LocalDataSource localDataSource;
    private volatile static FavoriteFilmRepository INSTANCE = null;

    public FavoriteFilmRepository(Application application) {
        FavoriteFilmRoomDatabase favoriteFilmRoomDatabase = FavoriteFilmRoomDatabase.getDatabase(application);
        favoriteFilmDao = favoriteFilmRoomDatabase.favoriteFilmDao();
        localDataSource = new LocalDataSource(favoriteFilmDao);
    }

    public static FavoriteFilmRepository getInstance(Application application){
        if(INSTANCE == null){
            synchronized (FavoriteFilmRepository.class){
                INSTANCE = new FavoriteFilmRepository(application);
            }
        }
        return INSTANCE;
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

    public void insertFilm(final FilmEntity filmEntity) {
        localDataSource.insertFilm(filmEntity);
    }

    public void deleteFilm(final FilmEntity filmEntity) {
        localDataSource.deleteFilm(filmEntity);
    }
}
