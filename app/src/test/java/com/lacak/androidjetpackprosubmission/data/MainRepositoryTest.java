package com.lacak.androidjetpackprosubmission.data;

import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainRepositoryTest {
    private RemoteDataSource remoteDataSource = Mockito.mock(RemoteDataSource.class);
    private FakeMainRepository fakeMainRepository = new FakeMainRepository(remoteDataSource);

    private List<FilmResponse> movieResponses = MoviesListDataGenerator.generateRemoteDummyMoviesListData();
    private String movieTitle = movieResponses.get(0).getTitle();

    private List<FilmResponse> showResponses = ShowsListDataGenerator.generateRemoteDummyShowsListData();
    private String showTitle = showResponses.get(0).getTitle();

    @Test
    public void getAllMovies(){
        when(remoteDataSource.getAllMovies()).thenReturn(movieResponses);
        ArrayList<FilmEntity> movieEntities = fakeMainRepository.getAllMovies();
        verify(remoteDataSource).getAllMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getAllShows(){
        when(remoteDataSource.getAllShows()).thenReturn(showResponses);
        ArrayList<FilmEntity> showEntities = fakeMainRepository.getAllShows();
        verify(remoteDataSource).getAllShows();
        assertNotNull(showEntities);
        assertEquals(showResponses.size(), showEntities.size());
    }

    @Test
    public void getDetailMovie(){
        when(remoteDataSource.getAllMovies()).thenReturn(movieResponses);
        FilmEntity movieEntity = fakeMainRepository.getDetailFilm(movieTitle);
        verify(remoteDataSource).getAllMovies();
        assertNotNull(movieEntity);
        assertEquals(movieResponses.get(0).getTitle(), movieEntity.getTitle());
    }

    @Test
    public void getDetailShow(){
        when(remoteDataSource.getAllShows()).thenReturn(showResponses);
        FilmEntity showEntity = fakeMainRepository.getDetailFilm(showTitle);
        verify(remoteDataSource).getAllShows();
        assertNotNull(showEntity);
        assertEquals(showResponses.get(0).getTitle(), showEntity.getTitle());
    }
}