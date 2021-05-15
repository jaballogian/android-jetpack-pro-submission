package com.lacak.androidjetpackprosubmission.ui.detail;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;
import com.lacak.androidjetpackprosubmission.utils.ShowsListDataGenerator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {

    private DetailViewModel detailMovieViewModel, detailShowViewModel, emptyMovieViewModel, emptyShowViewModel;
    private FilmEntity sampleMovieEntity = MoviesListDataGenerator.generateMoviesListData().get(0);
    private FilmEntity sampleShowEntity = ShowsListDataGenerator.generateShowsListData().get(0);
    private FilmEntity emptyFilmEntity = new FilmEntity("", "", "", "", "", "", "", "");

    @Before
    public void setUp(){
        detailMovieViewModel = new DetailViewModel();
        detailMovieViewModel.setFilmEntity(sampleMovieEntity);

        detailShowViewModel = new DetailViewModel();
        detailShowViewModel.setFilmEntity(sampleShowEntity);

        emptyMovieViewModel = new DetailViewModel();
        emptyMovieViewModel.setFilmEntity(emptyFilmEntity);

        emptyShowViewModel = new DetailViewModel();
        emptyShowViewModel.setFilmEntity(emptyFilmEntity);
    }

    @Test
    public void getFilmEntity() {
        // TEST SELECTED MOVIE WITH SAMPLE MOVIE DATA
        assertNotNull(sampleMovieEntity);
        assertEquals(sampleMovieEntity.getTitle(), detailMovieViewModel.getFilmEntity().getTitle());
        assertEquals(sampleMovieEntity.getGenres(), detailMovieViewModel.getFilmEntity().getGenres());
        assertEquals(sampleMovieEntity.getYear(), detailMovieViewModel.getFilmEntity().getYear());
        assertEquals(sampleMovieEntity.getRating(), detailMovieViewModel.getFilmEntity().getRating());
        assertEquals(sampleMovieEntity.getDuration(), detailMovieViewModel.getFilmEntity().getDuration());
        assertEquals(sampleMovieEntity.getOverview(), detailMovieViewModel.getFilmEntity().getOverview());
        assertEquals(sampleMovieEntity.getImagePath(), detailMovieViewModel.getFilmEntity().getImagePath());
        assertEquals(sampleMovieEntity.getUrl(), detailMovieViewModel.getFilmEntity().getUrl());

        // TEST SELECTED TV SHOW WITH SAMPLE TV SHOW DATA
        assertNotNull(sampleShowEntity);
        assertEquals(sampleShowEntity.getTitle(), detailShowViewModel.getFilmEntity().getTitle());
        assertEquals(sampleShowEntity.getGenres(), detailShowViewModel.getFilmEntity().getGenres());
        assertEquals(sampleShowEntity.getYear(), detailShowViewModel.getFilmEntity().getYear());
        assertEquals(sampleShowEntity.getRating(), detailShowViewModel.getFilmEntity().getRating());
        assertEquals(sampleShowEntity.getDuration(), detailShowViewModel.getFilmEntity().getDuration());
        assertEquals(sampleShowEntity.getOverview(), detailShowViewModel.getFilmEntity().getOverview());
        assertEquals(sampleShowEntity.getImagePath(), detailShowViewModel.getFilmEntity().getImagePath());
        assertEquals(sampleShowEntity.getUrl(), detailShowViewModel.getFilmEntity().getUrl());

        // TEST SELECTED MOVIE WITH SAMPLE EMPTY STRING DATA
        assertNotNull(emptyFilmEntity);
        assertEquals(emptyFilmEntity.getTitle(), emptyMovieViewModel.getFilmEntity().getTitle());
        assertEquals(emptyFilmEntity.getGenres(), emptyMovieViewModel.getFilmEntity().getGenres());
        assertEquals(emptyFilmEntity.getYear(), emptyMovieViewModel.getFilmEntity().getYear());
        assertEquals(emptyFilmEntity.getRating(), emptyMovieViewModel.getFilmEntity().getRating());
        assertEquals(emptyFilmEntity.getDuration(), emptyMovieViewModel.getFilmEntity().getDuration());
        assertEquals(emptyFilmEntity.getOverview(), emptyMovieViewModel.getFilmEntity().getOverview());
        assertEquals(emptyFilmEntity.getImagePath(), emptyMovieViewModel.getFilmEntity().getImagePath());
        assertEquals(emptyFilmEntity.getUrl(), emptyMovieViewModel.getFilmEntity().getUrl());

        // TEST SELECTED TV SHOW WITH SAMPLE EMPTY STRING DATA
        assertNotNull(emptyFilmEntity);
        assertEquals(emptyFilmEntity.getTitle(), emptyShowViewModel.getFilmEntity().getTitle());
        assertEquals(emptyFilmEntity.getGenres(), emptyShowViewModel.getFilmEntity().getGenres());
        assertEquals(emptyFilmEntity.getYear(), emptyShowViewModel.getFilmEntity().getYear());
        assertEquals(emptyFilmEntity.getRating(), emptyShowViewModel.getFilmEntity().getRating());
        assertEquals(emptyFilmEntity.getDuration(), emptyShowViewModel.getFilmEntity().getDuration());
        assertEquals(emptyFilmEntity.getOverview(), emptyShowViewModel.getFilmEntity().getOverview());
        assertEquals(emptyFilmEntity.getImagePath(), emptyShowViewModel.getFilmEntity().getImagePath());
        assertEquals(emptyFilmEntity.getUrl(), emptyShowViewModel.getFilmEntity().getUrl());
    }
}