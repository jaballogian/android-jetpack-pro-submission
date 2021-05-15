package com.lacak.androidjetpackprosubmission.ui.film;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FilmViewModelTest {

    private FilmViewModel filmViewModel;

    @Before
    public void setUp(){
        filmViewModel = new FilmViewModel();
    }

    @Test
    public void getMoviesListData() {
        List<FilmEntity> moviesList = filmViewModel.getMoviesListData();
        assertNotNull(moviesList);
        assertEquals(10, moviesList.size());
    }

    @Test
    public void getShowsListData() {
        List<FilmEntity> showsList = filmViewModel.getShowsListData();
        assertNotNull(showsList);
        assertEquals(10, showsList.size());
    }
}