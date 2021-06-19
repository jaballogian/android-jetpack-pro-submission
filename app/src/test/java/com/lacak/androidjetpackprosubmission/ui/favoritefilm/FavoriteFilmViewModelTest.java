package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
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
public class FavoriteFilmViewModelTest {
    private FavoriteFilmViewModel favoriteFilmViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FavoriteFilmRepository favoriteFilmRepository;

    @Mock
    private Observer<List<FilmEntity>> observer;

    @Before
    public void setUp() {
        favoriteFilmViewModel = new FavoriteFilmViewModel(favoriteFilmRepository);
    }

    @Test
    public void getAllFavoriteMovies() {
        List<FilmEntity> dummyMovies = MoviesListDataGenerator.generateMoviesListData();
        MutableLiveData<List<FilmEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(favoriteFilmViewModel.getAllFavoriteMovies()).thenReturn(movies);
        List<FilmEntity> moviesList = favoriteFilmViewModel.getAllFavoriteMovies().getValue();
        verify(favoriteFilmRepository).getAllFavoriteMovies();
        assertNotNull(moviesList);
        assertEquals(dummyMovies.size(), moviesList.size());

        favoriteFilmViewModel.getAllFavoriteMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

    @Test
    public void getAllFavoriteShows() {
        List<FilmEntity> dummyShows = ShowsListDataGenerator.generateShowsListData();
        MutableLiveData<List<FilmEntity>> shows = new MutableLiveData<>();
        shows.setValue(dummyShows);

        when(favoriteFilmViewModel.getAllFavoriteShows()).thenReturn(shows);
        List<FilmEntity> showsList = favoriteFilmViewModel.getAllFavoriteShows().getValue();
        verify(favoriteFilmRepository).getAllFavoriteShows();
        assertNotNull(showsList);
        assertEquals(dummyShows.size(), showsList.size());

        favoriteFilmViewModel.getAllFavoriteShows().observeForever(observer);
        verify(observer).onChanged(dummyShows);
    }
}