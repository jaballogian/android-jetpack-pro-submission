package com.lacak.androidjetpackprosubmission.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FakeFavoriteFilmRepository {
    private FavoriteFilmDao favoriteFilmDao;
    private ExecutorService executorService;

    FakeFavoriteFilmRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        FavoriteFilmRoomDatabase favoriteFilmRoomDatabase = FavoriteFilmRoomDatabase.getDatabase(application);
        favoriteFilmDao = favoriteFilmRoomDatabase.favoriteFilmDao();
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
