package com.lacak.androidjetpackprosubmission.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;
import com.lacak.androidjetpackprosubmission.utils.LiveDataTestUtil;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.PagedListUtil;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteFilmRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalDataSource localDataSource = mock(LocalDataSource.class);
    private FakeFavoriteFilmRepository fakeFavoriteFilmRepository = new FakeFavoriteFilmRepository(localDataSource);

    private List<FilmResponse> movieResponses = MoviesListDataGenerator.generateRemoteDummyMoviesListData();
    private List<FilmResponse> showResponses = ShowsListDataGenerator.generateRemoteDummyShowsListData();

    private FilmEntity movieEntity = MoviesListDataGenerator.generateMoviesListData().get(0);
    private FilmEntity showEntity = ShowsListDataGenerator.generateShowsListData().get(0);

    private int movieId = movieEntity.getId();
    private int showId = showEntity.getId();

    @Test
    public void getAllFavoriteMovies() {
        DataSource.Factory<Integer, FilmEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSource.getAllFavoriteMovies()).thenReturn(dataSourceFactory);
        fakeFavoriteFilmRepository.getAllFavoriteMovies();

        PagedList<FilmEntity> moviesEntities = PagedListUtil.mockPagedList(MoviesListDataGenerator.generateMoviesListData());
        verify(localDataSource).getAllFavoriteMovies();
        assertNotNull(moviesEntities);
        assertEquals(movieResponses.size(), moviesEntities.size());
    }

    @Test
    public void getAllFavoriteShows() {
        DataSource.Factory<Integer, FilmEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSource.getAllFavoriteShows()).thenReturn(dataSourceFactory);
        fakeFavoriteFilmRepository.getAllFavoriteShows();

        PagedList<FilmEntity> showsEntities = PagedListUtil.mockPagedList(ShowsListDataGenerator.generateShowsListData());
        verify(localDataSource).getAllFavoriteShows();
        assertNotNull(showsEntities);
        assertEquals(showResponses.size(), showsEntities.size());
    }

    @Test
    public void getDetailFavoriteMovie() {
        MutableLiveData<FilmEntity> dummyMovieEntity = new MutableLiveData<>();
        dummyMovieEntity.setValue(MoviesListDataGenerator.generateMoviesListData().get(0));
        when(localDataSource.getDetailFavoriteMovie(movieId)).thenReturn(dummyMovieEntity);

        FilmEntity movieEntity = LiveDataTestUtil.getValue(fakeFavoriteFilmRepository.getDetailFavoriteMovie(movieId));
        verify(localDataSource).getDetailFavoriteMovie(movieId);
        assertNotNull(movieEntity);
        assertEquals(dummyMovieEntity.getValue(), movieEntity);
    }

    @Test
    public void getDetailFavoriteShow() {
        MutableLiveData<FilmEntity> dummyShowEntity = new MutableLiveData<>();
        dummyShowEntity.setValue(ShowsListDataGenerator.generateShowsListData().get(0));
        when(localDataSource.getDetailFavoriteShow(showId)).thenReturn(dummyShowEntity);

        FilmEntity showEntity = LiveDataTestUtil.getValue(fakeFavoriteFilmRepository.getDetailFavoriteShow(showId));
        verify(localDataSource).getDetailFavoriteShow(showId);
        assertNotNull(showEntity);
        assertEquals(dummyShowEntity.getValue(), showEntity);
    }
}