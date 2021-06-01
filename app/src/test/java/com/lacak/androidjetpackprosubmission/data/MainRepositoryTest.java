package com.lacak.androidjetpackprosubmission.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;
import com.lacak.androidjetpackprosubmission.utils.LiveDataTestUtil;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class MainRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remoteDataSource = Mockito.mock(RemoteDataSource.class);
    private FakeMainRepository fakeMainRepository = new FakeMainRepository(remoteDataSource);

    private List<FilmResponse> movieResponses = MoviesListDataGenerator.generateRemoteDummyMoviesListData();
    private String movieTitle = movieResponses.get(0).getTitle();

    private List<FilmResponse> showResponses = ShowsListDataGenerator.generateRemoteDummyShowsListData();
    private String showTitle = showResponses.get(0).getTitle();

    @Test
    public void getAllMovies(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        List<FilmEntity> movieEntities = LiveDataTestUtil.getValue(fakeMainRepository.getAllMovies());
        verify(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getAllShows(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadShowsCallback) invocation.getArguments()[0]).onAllShowsReceived(showResponses);
            return null;
        }).when(remoteDataSource).getAllShows(any(RemoteDataSource.LoadShowsCallback.class));
        List<FilmEntity> showEntities = LiveDataTestUtil.getValue(fakeMainRepository.getAllShows());
        verify(remoteDataSource).getAllShows(any(RemoteDataSource.LoadShowsCallback.class));
        assertNotNull(showEntities);
        assertEquals(showResponses.size(), showEntities.size());
    }

    @Test
    public void getDetailMovie(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        FilmEntity movieEntity = LiveDataTestUtil.getValue(fakeMainRepository.getDetailFilm(movieTitle));
        verify(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        assertNotNull(movieEntity);
        assertEquals(movieResponses.get(0).getTitle(), movieEntity.getTitle());
    }

    @Test
    public void getDetailShow(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadShowsCallback) invocation.getArguments()[0]).onAllShowsReceived(showResponses);
            return null;
        }).when(remoteDataSource).getAllShows(any(RemoteDataSource.LoadShowsCallback.class));
        FilmEntity showEntity = LiveDataTestUtil.getValue(fakeMainRepository.getDetailFilm(showTitle));
        verify(remoteDataSource).getAllShows(any(RemoteDataSource.LoadShowsCallback.class));
        assertNotNull(showEntity);
        assertEquals(showResponses.get(0).getTitle(), showEntity.getTitle());
    }
}