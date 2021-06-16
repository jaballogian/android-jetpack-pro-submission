package com.lacak.androidjetpackprosubmission.ui.favoritedetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

public class FavoriteDetailViewModel extends ViewModel {
    private int id;
    private FavoriteFilmRepository favoriteFilmRepository;

    public FavoriteDetailViewModel(FavoriteFilmRepository favoriteFilmRepository) {
        this.favoriteFilmRepository = favoriteFilmRepository;
    }

    public void setSelectedFavoriteMovie(int id) {
        this.id = id;
    }

    public void setSelectedFavoriteShow(int id) {
        this.id = id;
    }

    public LiveData<FilmEntity> getSelectedFavoriteMovie() {
        return favoriteFilmRepository.getDetailFavoriteMovie(id);
    }

    public LiveData<FilmEntity> getSelectedFavoriteShow() {
        return favoriteFilmRepository.getDetailFavoriteShow(id);
    }

    public void deleteFavoriteFilm(FilmEntity filmEntity) {
        favoriteFilmRepository.deleteFilm(filmEntity);
    }
}
