package com.lacak.androidjetpackprosubmission.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.MainRepository;

public class DetailViewModel extends ViewModel {
    private String title;
    private MainRepository mainRepository;

    public DetailViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
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
}
