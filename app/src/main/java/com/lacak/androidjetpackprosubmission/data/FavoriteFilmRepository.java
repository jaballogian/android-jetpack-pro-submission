package com.lacak.androidjetpackprosubmission.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

public class FavoriteFilmRepository {
    private LocalDataSource localDataSource;
    private volatile static FavoriteFilmRepository INSTANCE = null;

    public FavoriteFilmRepository(@NonNull LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    public static FavoriteFilmRepository getInstance(LocalDataSource localDataSource){
        if(INSTANCE == null){
            synchronized (FavoriteFilmRepository.class){
                INSTANCE = new FavoriteFilmRepository(localDataSource);
            }
        }
        return INSTANCE;
    }

    public LiveData<PagedList<FilmEntity>> getAllFavoriteMovies() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(5)
                .setPageSize(5)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getAllFavoriteMovies(), config).build();
    }

    public LiveData<PagedList<FilmEntity>> getAllFavoriteShows() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(5)
                .setPageSize(5)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getAllFavoriteShows(), config).build();
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
