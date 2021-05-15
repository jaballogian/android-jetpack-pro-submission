package com.lacak.androidjetpackprosubmission.ui.film;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
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
        // TEST WITH FULL DATA
        List<FilmEntity> moviesList = filmViewModel.getMoviesListData();
        assertNotNull(moviesList);
        assertEquals(10, moviesList.size());

        // TEST WITH HALF DATA
        List<FilmEntity> halfMoviesList = filmViewModel.getMoviesListData().subList(0, 5);
        assertNotNull(halfMoviesList);
        assertEquals(5, halfMoviesList.size());

        // TEST WITH ZERO DATA
        List<FilmEntity> zeroMoviesList = filmViewModel.getMoviesListData().subList(0, 0);
        assertNotNull(zeroMoviesList);
        assertEquals(0, zeroMoviesList.size());
    }

    @Test
    public void getShowsListData() {
        // TEST WITH FULL DATA
        List<FilmEntity> showsList = filmViewModel.getShowsListData();
        assertNotNull(showsList);
        assertEquals(10, showsList.size());

        // TEST WITH HALF DATA
        List<FilmEntity> halfShowsList = filmViewModel.getShowsListData().subList(0, 5);
        assertNotNull(halfShowsList);
        assertEquals(5, halfShowsList.size());

        // TEST WITH ZERO DATA
        List<FilmEntity> zeroShowsList = filmViewModel.getShowsListData().subList(0, 0);
        assertNotNull(zeroShowsList);
        assertEquals(0, zeroShowsList.size());
    }



}