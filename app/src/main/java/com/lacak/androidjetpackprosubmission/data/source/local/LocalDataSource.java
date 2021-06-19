package com.lacak.androidjetpackprosubmission.data.source.local;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final FavoriteFilmDao favoriteFilmDao;
    private ExecutorService executorService;

    public LocalDataSource(FavoriteFilmDao favoriteFilmDao, ExecutorService executorService) {
        this.executorService = executorService;
        this.favoriteFilmDao = favoriteFilmDao;
    }

    public static LocalDataSource getInstance(FavoriteFilmDao favoriteFilmDao, ExecutorService executorService) {
        if(INSTANCE == null) {
            INSTANCE = new LocalDataSource(favoriteFilmDao, executorService);
        }
        return INSTANCE;
    }

    public LiveData<List<FilmEntity>> getAllFavoriteMovies() {
        return favoriteFilmDao.getAllFavoriteMovies();
    }

    public LiveData<List<FilmEntity>> getAllFavoriteShows() {
        return favoriteFilmDao.getAllFavoriteShows();
    }

    public LiveData<FilmEntity> getDetailFavoriteMovie(int id) {
        return favoriteFilmDao.getDetailFavoriteMovie(id);
    }

    public LiveData<FilmEntity> getDetailFavoriteShow(int id) {
        return favoriteFilmDao.getDetailFavoriteShow(id);
    }

    public void insertFilm(final FilmEntity filmEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                favoriteFilmDao.insertFilm(filmEntity);
            }
        });
    }

    public void deleteFilm(final FilmEntity filmEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                favoriteFilmDao.deleteFilm(filmEntity);
            }
        });
    }
}
