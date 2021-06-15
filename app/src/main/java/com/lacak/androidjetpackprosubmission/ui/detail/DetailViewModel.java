package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.MainRepository;

public class DetailViewModel extends ViewModel {
    private String title;
    private MainRepository mainRepository;
    private FavoriteFilmRepository favoriteFilmRepository;

    public DetailViewModel(MainRepository mainRepository, FavoriteFilmRepository favoriteFilmRepository){
        this.mainRepository = mainRepository;
        this.favoriteFilmRepository = favoriteFilmRepository;
    }

    public void setSelectedMovie(String title){
        this.title = title;
    }

    public void setSelectedShow(String title){
        this.title = title;
    }

    public LiveData<FilmEntity> getSelectedMovie(){
        return mainRepository.getDetailMovie(title);
    }

    public LiveData<FilmEntity> getSelectedShow(){
        return mainRepository.getDetailShow(title);
    }

    public void insertFavoriteFilm(FilmEntity filmEntity){
        favoriteFilmRepository.insertFilm(filmEntity);
    }
}
