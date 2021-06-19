package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

import java.util.List;

public class FavoriteFilmViewModel extends ViewModel {
    private FavoriteFilmRepository favoriteFilmRepository;

    public FavoriteFilmViewModel(FavoriteFilmRepository favoriteFilmRepository) {
        this.favoriteFilmRepository = favoriteFilmRepository;
    }

    LiveData<List<FilmEntity>> getAllFavoriteMovies() {
        return favoriteFilmRepository.getAllFavoriteMovies();
    }

    LiveData<List<FilmEntity>> getAllFavoriteShows() {
        return favoriteFilmRepository.getAllFavoriteShows();
    }
}
