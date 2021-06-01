package com.lacak.androidjetpackprosubmission.ui.film;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.MainRepository;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FilmViewModelTest {

    private FilmViewModel filmViewModel;

    @Mock
    private MainRepository mainRepository;

    @Before
    public void setUp(){
        filmViewModel = new FilmViewModel(mainRepository);
    }

    @Test
    public void getMoviesListData() {
        when(mainRepository.getAllMovies()).thenReturn(MoviesListDataGenerator.generateMoviesListData());
        List<FilmEntity> moviesList = filmViewModel.getMoviesListData();
        verify(mainRepository.getAllMovies());
        assertNotNull(moviesList);
        assertEquals(10, moviesList.size());
    }

    @Test
    public void getShowsListData() {
        when(mainRepository.getAllShows()).thenReturn(ShowsListDataGenerator.generateShowsListData());
        List<FilmEntity> showsList = filmViewModel.getShowsListData();
        verify(mainRepository.getAllShows());
        assertNotNull(showsList);
        assertEquals(10, showsList.size());
    }
}