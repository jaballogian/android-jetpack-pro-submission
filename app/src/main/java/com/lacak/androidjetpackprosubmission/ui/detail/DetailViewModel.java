package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

public class DetailViewModel extends ViewModel {
    private FilmEntity filmEntity;

    public FilmEntity getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }
}
