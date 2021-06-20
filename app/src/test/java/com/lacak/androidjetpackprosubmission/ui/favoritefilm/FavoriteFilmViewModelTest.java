package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

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
    private Observer<PagedList<FilmEntity>> observer;

    @Mock
    private PagedList<FilmEntity> pagedList;

    @Before
    public void setUp() {
        favoriteFilmViewModel = new FavoriteFilmViewModel(favoriteFilmRepository);
    }

    @Test
    public void getAllFavoriteMovies() {
        PagedList<FilmEntity> dummyMovies = pagedList;
        when(dummyMovies.size()).thenReturn(5);
        MutableLiveData<PagedList<FilmEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(favoriteFilmRepository.getAllFavoriteMovies()).thenReturn(movies);
        List<FilmEntity> moviesEntities = favoriteFilmViewModel.getAllFavoriteMovies().getValue();
        verify(favoriteFilmRepository).getAllFavoriteMovies();
        assertNotNull(moviesEntities);
        assertEquals(5, moviesEntities.size());

        favoriteFilmViewModel.getAllFavoriteMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

    @Test
    public void getAllFavoriteShows() {
        PagedList<FilmEntity> dummyShows = pagedList;
        when(dummyShows.size()).thenReturn(5);
        MutableLiveData<PagedList<FilmEntity>> shows = new MutableLiveData<>();
        shows.setValue(dummyShows);

        when(favoriteFilmRepository.getAllFavoriteShows()).thenReturn(shows);
        List<FilmEntity> showsEntities = favoriteFilmViewModel.getAllFavoriteShows().getValue();
        verify(favoriteFilmRepository).getAllFavoriteShows();
        assertNotNull(showsEntities);
        assertEquals(5, showsEntities.size());

        favoriteFilmViewModel.getAllFavoriteShows().observeForever(observer);
        verify(observer).onChanged(dummyShows);
    }
}