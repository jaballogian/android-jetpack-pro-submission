package com.lacak.androidjetpackprosubmission.ui.favoritedetail;

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

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteDetailViewModelTest {
    private FavoriteDetailViewModel favoriteDetailMovieViewModel, favoriteDetailShowViewModel;
    private FilmEntity sampleMovieEntity = MoviesListDataGenerator.generateMoviesListData().get(0);
    private FilmEntity sampleShowEntity = ShowsListDataGenerator.generateShowsListData().get(0);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private FavoriteFilmRepository favoriteFilmRepository;

    @Mock
    private Observer<FilmEntity> movieObserver, showObserver;

    @Before
    public void setUp() {
        favoriteDetailMovieViewModel = new FavoriteDetailViewModel(favoriteFilmRepository);
        favoriteDetailMovieViewModel.setSelectedFavoriteMovie(sampleMovieEntity.getId());

        favoriteDetailShowViewModel = new FavoriteDetailViewModel(favoriteFilmRepository);
        favoriteDetailShowViewModel.setSelectedFavoriteShow(sampleShowEntity.getId());
    }

    @Test
    public void getSelectedFavoriteMovie() {
        MutableLiveData<FilmEntity> movie = new MutableLiveData<>();
        movie.setValue(sampleMovieEntity);
        when(favoriteFilmRepository.getDetailFavoriteMovie(sampleMovieEntity.getId())).thenReturn(movie);
        FilmEntity movieEntity = favoriteDetailMovieViewModel.getSelectedFavoriteMovie().getValue();
        verify(favoriteFilmRepository).getDetailFavoriteMovie(sampleMovieEntity.getId());
        assertNotNull(movieEntity);
        assertEquals(sampleMovieEntity.getId(), movieEntity.getId());
        assertEquals(sampleMovieEntity.getTitle(), movieEntity.getTitle());
        assertEquals(sampleMovieEntity.getGenres(), movieEntity.getGenres());
        assertEquals(sampleMovieEntity.getYear(), movieEntity.getYear());
        assertEquals(sampleMovieEntity.getRating(), movieEntity.getRating());
        assertEquals(sampleMovieEntity.getDuration(), movieEntity.getDuration());
        assertEquals(sampleMovieEntity.getOverview(), movieEntity.getOverview());
        assertEquals(sampleMovieEntity.getImagePath(), movieEntity.getImagePath());
        assertEquals(sampleMovieEntity.getUrl(), movieEntity.getUrl());
        assertEquals(sampleMovieEntity.getType(), movieEntity.getType());

        favoriteDetailMovieViewModel.getSelectedFavoriteMovie().observeForever(movieObserver);
        verify(movieObserver).onChanged(sampleMovieEntity);
    }

    @Test
    public void getSelectedFavoriteShow() {
        MutableLiveData<FilmEntity> show = new MutableLiveData<>();
        show.setValue(sampleShowEntity);
        when(favoriteFilmRepository.getDetailFavoriteShow(sampleShowEntity.getId())).thenReturn(show);
        FilmEntity showEntity = favoriteDetailShowViewModel.getSelectedFavoriteShow().getValue();
        verify(favoriteFilmRepository).getDetailFavoriteShow(sampleShowEntity.getId());
        assertNotNull(showEntity);
        assertEquals(sampleShowEntity.getId(), showEntity.getId());
        assertEquals(sampleShowEntity.getTitle(), showEntity.getTitle());
        assertEquals(sampleShowEntity.getGenres(), showEntity.getGenres());
        assertEquals(sampleShowEntity.getYear(), showEntity.getYear());
        assertEquals(sampleShowEntity.getRating(), showEntity.getRating());
        assertEquals(sampleShowEntity.getDuration(), showEntity.getDuration());
        assertEquals(sampleShowEntity.getOverview(), showEntity.getOverview());
        assertEquals(sampleShowEntity.getImagePath(), showEntity.getImagePath());
        assertEquals(sampleShowEntity.getUrl(), showEntity.getUrl());
        assertEquals(sampleShowEntity.getType(), showEntity.getType());

        favoriteDetailShowViewModel.getSelectedFavoriteShow().observeForever(showObserver);
        verify(showObserver).onChanged(sampleShowEntity);
    }
}