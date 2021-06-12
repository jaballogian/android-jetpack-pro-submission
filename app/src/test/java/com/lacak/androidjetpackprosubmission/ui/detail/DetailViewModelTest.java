package com.lacak.androidjetpackprosubmission.ui.detail;

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

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {

    private DetailViewModel detailMovieViewModel, detailShowViewModel;
    private FilmEntity sampleMovieEntity = MoviesListDataGenerator.generateMoviesListData().get(0);
    private FilmEntity sampleShowEntity = ShowsListDataGenerator.generateShowsListData().get(0);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MainRepository mainRepository;

    @Mock
    private Observer<FilmEntity> movieObserver, showObserver;

    @Before
    public void setUp(){
        detailMovieViewModel = new DetailViewModel(mainRepository);
        detailMovieViewModel.setSelectedFilm(sampleMovieEntity.getTitle());

        detailShowViewModel = new DetailViewModel(mainRepository);
        detailShowViewModel.setSelectedFilm(sampleShowEntity.getTitle());
    }

    @Test
    public void getFilmEntity() {
        MutableLiveData<FilmEntity> movie = new MutableLiveData<>();
        movie.setValue(sampleMovieEntity);
        when(mainRepository.getDetailFilm(sampleMovieEntity.getTitle())).thenReturn(movie);
        FilmEntity movieEntity = detailMovieViewModel.getSelectedFilm().getValue();
        verify(mainRepository).getDetailFilm(sampleMovieEntity.getTitle());
        assertNotNull(movieEntity);
        assertEquals(sampleMovieEntity.getTitle(), movieEntity.getTitle());
        assertEquals(sampleMovieEntity.getGenres(), movieEntity.getGenres());
        assertEquals(sampleMovieEntity.getYear(), movieEntity.getYear());
        assertEquals(sampleMovieEntity.getRating(), movieEntity.getRating());
        assertEquals(sampleMovieEntity.getDuration(), movieEntity.getDuration());
        assertEquals(sampleMovieEntity.getOverview(), movieEntity.getOverview());
        assertEquals(sampleMovieEntity.getImagePath(), movieEntity.getImagePath());
        assertEquals(sampleMovieEntity.getUrl(), movieEntity.getUrl());

        detailMovieViewModel.getSelectedFilm().observeForever(movieObserver);
        verify(movieObserver).onChanged(sampleMovieEntity);

        MutableLiveData<FilmEntity> show = new MutableLiveData<>();
        show.setValue(sampleShowEntity);
        when(mainRepository.getDetailFilm(sampleShowEntity.getTitle())).thenReturn(show);
        FilmEntity showEntity = detailShowViewModel.getSelectedFilm().getValue();
        verify(mainRepository).getDetailFilm(sampleShowEntity.getTitle());
        assertNotNull(showEntity);
        assertEquals(sampleShowEntity.getTitle(), showEntity.getTitle());
        assertEquals(sampleShowEntity.getGenres(), showEntity.getGenres());
        assertEquals(sampleShowEntity.getYear(), showEntity.getYear());
        assertEquals(sampleShowEntity.getRating(), showEntity.getRating());
        assertEquals(sampleShowEntity.getDuration(), showEntity.getDuration());
        assertEquals(sampleShowEntity.getOverview(), showEntity.getOverview());
        assertEquals(sampleShowEntity.getImagePath(), showEntity.getImagePath());
        assertEquals(sampleShowEntity.getUrl(), showEntity.getUrl());

        detailShowViewModel.getSelectedFilm().observeForever(showObserver);
        verify(showObserver).onChanged(sampleShowEntity);
    }
}