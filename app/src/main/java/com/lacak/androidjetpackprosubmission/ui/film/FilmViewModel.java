package com.lacak.androidjetpackprosubmission.ui.film;

import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.MainRepository;

import java.util.List;

public class FilmViewModel extends ViewModel {

    private MainRepository mainRepository;

    public FilmViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public List<FilmEntity> getMoviesListData(){
        return mainRepository.getAllMovies();
    }

    public List<FilmEntity> getShowsListData(){
        return mainRepository.getAllShows();
    }
}
