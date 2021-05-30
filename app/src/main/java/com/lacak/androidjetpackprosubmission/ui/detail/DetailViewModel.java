package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.MainRepository;

public class DetailViewModel extends ViewModel {
    private String title;
    private MainRepository mainRepository;

    public DetailViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public void setSelectedFilm(String title){
        this.title = title;
    }

    public LiveData<FilmEntity> getSelectedFilm(){
        return mainRepository.getDetailFilm(title);
    }
}
