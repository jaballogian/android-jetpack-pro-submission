package com.lacak.androidjetpackprosubmission.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FavoriteFilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteFilmRepository {
    private FavoriteFilmDao favoriteFilmDao;
    private ExecutorService executorService;

    public FavoriteFilmRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        FavoriteFilmRoomDatabase favoriteFilmRoomDatabase = FavoriteFilmRoomDatabase.getDatabase(application);
        favoriteFilmDao = favoriteFilmRoomDatabase.favoriteFilmDao();
    }

    public LiveData<List<FavoriteFilmEntity>> getAllFavoriteMovies() {
        return favoriteFilmDao.getAllFavoriteMovies();
    }

    public LiveData<List<FavoriteFilmEntity>> getAllFavoriteShows() {
        return favoriteFilmDao.getAllFavoriteShows();
    }

    public void insertFilm(final FavoriteFilmEntity favoriteFilmEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                favoriteFilmDao.insertFilm(favoriteFilmEntity);
            }
        });
    }

    public void deleteFilm(final FavoriteFilmEntity favoriteFilmEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                favoriteFilmDao.deleteFilm(favoriteFilmEntity);
            }
        });
    }
}
