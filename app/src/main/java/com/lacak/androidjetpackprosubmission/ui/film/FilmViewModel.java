package com.lacak.androidjetpackprosubmission.ui.film;

import androidx.lifecycle.ViewModel;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import java.util.List;

public class FilmViewModel extends ViewModel {

    public List<FilmEntity> getMoviesListData(){
        return MoviesListDataGenerator.generateMoviesListData();
    }

    public List<FilmEntity> getShowsListData(){
        return ShowsListDataGenerator.generateShowsListData();
    }
}
