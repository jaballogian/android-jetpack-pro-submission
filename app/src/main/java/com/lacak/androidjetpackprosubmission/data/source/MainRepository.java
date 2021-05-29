package com.lacak.androidjetpackprosubmission.data.source;

import androidx.annotation.NonNull;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;

import java.util.ArrayList;
import java.util.List;

public class MainRepository implements MainDataSource{
    private volatile static MainRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;

    private MainRepository(@NonNull RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    public static MainRepository getInstance(RemoteDataSource remoteDataSource){
        if(INSTANCE == null){
            synchronized (MainRepository.class){
                INSTANCE = new MainRepository(remoteDataSource);
            }
        }
        return INSTANCE;
    }

    @Override
    public List<FilmEntity> getAllMovies() {
        List<FilmResponse> movieResponses = remoteDataSource.getAllMovies();
        ArrayList<FilmEntity> moviesList = new ArrayList<>();
        for (FilmResponse response : movieResponses) {
            FilmEntity movie = new FilmEntity(
                    response.getTitle(),
                    response.getYear(),
                    response.getGenres(),
                    response.getDuration(),
                    response.getRating(),
                    response.getOverview(),
                    response.getUrl(),
                    response.getImagePath()
            );
            moviesList.add(movie);
        }
        return moviesList;
    }

    @Override
    public List<FilmEntity> getAllShows() {
        List<FilmResponse> showResponses = remoteDataSource.getAllShows();
        ArrayList<FilmEntity> showsList = new ArrayList<>();
        for (FilmResponse response : showResponses) {
            FilmEntity show = new FilmEntity(
                    response.getTitle(),
                    response.getYear(),
                    response.getGenres(),
                    response.getDuration(),
                    response.getRating(),
                    response.getOverview(),
                    response.getUrl(),
                    response.getImagePath()
            );
            showsList.add(show);
        }
        return showsList;
    }

    @Override
    public FilmEntity getDetailFilm(final String title) {
        List<FilmResponse> movieResponses = remoteDataSource.getAllMovies();
        FilmEntity film = null;
        for (FilmResponse response : movieResponses) {
            if (response.getTitle().equals(title)) {
                film = new FilmEntity(
                    response.getTitle(),
                    response.getYear(),
                    response.getGenres(),
                    response.getDuration(),
                    response.getRating(),
                    response.getOverview(),
                    response.getUrl(),
                    response.getImagePath());
            }
        }

        if(film == null){
            List<FilmResponse> showResponses = remoteDataSource.getAllShows();
            for (FilmResponse response : showResponses) {
                if (response.getTitle().equals(title)) {
                    film = new FilmEntity(
                        response.getTitle(),
                        response.getYear(),
                        response.getGenres(),
                        response.getDuration(),
                        response.getRating(),
                        response.getOverview(),
                        response.getUrl(),
                        response.getImagePath());
                }
            }
            return film;
        }
        return film;
    }
}
