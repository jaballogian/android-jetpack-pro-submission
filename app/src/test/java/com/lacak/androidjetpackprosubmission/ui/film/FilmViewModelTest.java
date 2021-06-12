package com.lacak.androidjetpackprosubmission.ui.film;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.MainRepository;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Before;
import org.junit.Rule;
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

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MainRepository mainRepository;

    @Mock
    private Observer<List<FilmEntity>> observer;

    @Before
    public void setUp(){
        filmViewModel = new FilmViewModel(mainRepository);
    }

    @Test
    public void getMoviesListData() {
        List<FilmEntity> dummyMovies = MoviesListDataGenerator.generateMoviesListData();
        MutableLiveData<List<FilmEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(mainRepository.getAllMovies()).thenReturn(movies);
        List<FilmEntity> moviesList = filmViewModel.getMoviesListData().getValue();
        verify(mainRepository).getAllMovies();
        assertNotNull(moviesList);
        assertEquals(10, moviesList.size());

        filmViewModel.getMoviesListData().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

    @Test
    public void getShowsListData() {
        List<FilmEntity> dummyShows = ShowsListDataGenerator.generateShowsListData();
        MutableLiveData<List<FilmEntity>> shows = new MutableLiveData<>();
        shows.setValue(dummyShows);

        when(mainRepository.getAllShows()).thenReturn(shows);
        List<FilmEntity> showsList = filmViewModel.getShowsListData().getValue();
        verify(mainRepository).getAllShows();
        assertNotNull(showsList);
        assertEquals(10, showsList.size());

        filmViewModel.getShowsListData().observeForever(observer);
        verify(observer).onChanged(dummyShows);
    }
}