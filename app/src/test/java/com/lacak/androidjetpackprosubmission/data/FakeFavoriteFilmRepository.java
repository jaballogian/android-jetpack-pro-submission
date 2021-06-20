package com.lacak.androidjetpackprosubmission.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

public class FakeFavoriteFilmRepository {
    private LocalDataSource localDataSource;

    public FakeFavoriteFilmRepository(@NonNull LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
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
}
