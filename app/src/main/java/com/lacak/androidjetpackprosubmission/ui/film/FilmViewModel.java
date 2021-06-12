package com.lacak.androidjetpackprosubmission.ui.film;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.MainRepository;

import java.util.List;

public class FilmViewModel extends ViewModel {

    private MainRepository mainRepository;

    public FilmViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public LiveData<List<FilmEntity>> getMoviesListData(){
        return mainRepository.getAllMovies();
    }

    public LiveData<List<FilmEntity>> getShowsListData(){
        return mainRepository.getAllShows();
    }
}
