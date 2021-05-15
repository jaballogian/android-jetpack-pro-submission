package com.lacak.androidjetpackprosubmission.ui.detail;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {

    private DetailViewModel detailMovieViewModel, detailShowViewModel;
    private FilmEntity sampleMovieEntity = MoviesListDataGenerator.generateMoviesListData().get(0);
    private FilmEntity sampleShowEntity = ShowsListDataGenerator.generateShowsListData().get(0);

    @Before
    public void setUp(){
        detailMovieViewModel = new DetailViewModel();
        detailMovieViewModel.setFilmEntity(sampleMovieEntity);

        detailShowViewModel = new DetailViewModel();
        detailShowViewModel.setFilmEntity(sampleShowEntity);
    }

    @Test
    public void getFilmEntity() {
        assertNotNull(sampleMovieEntity);
        assertEquals(sampleMovieEntity.getTitle(), detailMovieViewModel.getFilmEntity().getTitle());
        assertEquals(sampleMovieEntity.getGenres(), detailMovieViewModel.getFilmEntity().getGenres());
        assertEquals(sampleMovieEntity.getYear(), detailMovieViewModel.getFilmEntity().getYear());
        assertEquals(sampleMovieEntity.getRating(), detailMovieViewModel.getFilmEntity().getRating());
        assertEquals(sampleMovieEntity.getDuration(), detailMovieViewModel.getFilmEntity().getDuration());
        assertEquals(sampleMovieEntity.getOverview(), detailMovieViewModel.getFilmEntity().getOverview());
        assertEquals(sampleMovieEntity.getImagePath(), detailMovieViewModel.getFilmEntity().getImagePath());
        assertEquals(sampleMovieEntity.getUrl(), detailMovieViewModel.getFilmEntity().getUrl());

        assertNotNull(sampleShowEntity);
        assertEquals(sampleShowEntity.getTitle(), detailShowViewModel.getFilmEntity().getTitle());
        assertEquals(sampleShowEntity.getGenres(), detailShowViewModel.getFilmEntity().getGenres());
        assertEquals(sampleShowEntity.getYear(), detailShowViewModel.getFilmEntity().getYear());
        assertEquals(sampleShowEntity.getRating(), detailShowViewModel.getFilmEntity().getRating());
        assertEquals(sampleShowEntity.getDuration(), detailShowViewModel.getFilmEntity().getDuration());
        assertEquals(sampleShowEntity.getOverview(), detailShowViewModel.getFilmEntity().getOverview());
        assertEquals(sampleShowEntity.getImagePath(), detailShowViewModel.getFilmEntity().getImagePath());
        assertEquals(sampleShowEntity.getUrl(), detailShowViewModel.getFilmEntity().getUrl());
    }
}