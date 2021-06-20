package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

public class FavoriteFilmViewModel extends ViewModel {
    private FavoriteFilmRepository favoriteFilmRepository;

    public FavoriteFilmViewModel(FavoriteFilmRepository favoriteFilmRepository) {
        this.favoriteFilmRepository = favoriteFilmRepository;
    }

    public LiveData<PagedList<FilmEntity>> getAllFavoriteMovies() {
        return favoriteFilmRepository.getAllFavoriteMovies();
    }

    public LiveData<PagedList<FilmEntity>> getAllFavoriteShows() {
        return favoriteFilmRepository.getAllFavoriteShows();
    }
}
