package com.lacak.androidjetpackprosubmission.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeMainRepository implements MainDataSource{
    private final RemoteDataSource remoteDataSource;

    FakeMainRepository(@NonNull RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public LiveData<List<FilmEntity>> getAllMovies() {
        MutableLiveData<List<FilmEntity>> movieResults = new MutableLiveData<>();
        remoteDataSource.getAllMovies(movieResponses -> {
            ArrayList<FilmEntity> moviesList = new ArrayList<>();
            for (FilmResponse response : movieResponses) {
                FilmEntity movie = new FilmEntity(
                        response.getId(),
                        response.getTitle(),
                        response.getYear(),
                        response.getGenres(),
                        response.getDuration(),
                        response.getRating(),
                        response.getOverview(),
                        response.getUrl(),
                        response.getImagePath(),
                        response.getType()
                );
                moviesList.add(movie);
            }
            movieResults.postValue(moviesList);
        });

        return movieResults;
    }

    @Override
    public LiveData<List<FilmEntity>> getAllShows() {
        MutableLiveData<List<FilmEntity>> showResults = new MutableLiveData<>();
        remoteDataSource.getAllShows(showResponses -> {
            ArrayList<FilmEntity> showsList = new ArrayList<>();
            for (FilmResponse response : showResponses) {
                FilmEntity show = new FilmEntity(
                        response.getId(),
                        response.getTitle(),
                        response.getYear(),
                        response.getGenres(),
                        response.getDuration(),
                        response.getRating(),
                        response.getOverview(),
                        response.getUrl(),
                        response.getImagePath(),
                        response.getType()
                );
                showsList.add(show);
            }
            showResults.postValue(showsList);
        });

        return showResults;
    }

    @Override
    public LiveData<FilmEntity> getDetailMovie(final String title) {
        MutableLiveData<FilmEntity> detailMovieResult = new MutableLiveData<>();

        remoteDataSource.getAllMovies(movieResponses -> {
            FilmEntity movie = null;
            for (FilmResponse response : movieResponses) {
                if (response.getTitle().equals(title)) {
                    movie = new FilmEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getYear(),
                            response.getGenres(),
                            response.getDuration(),
                            response.getRating(),
                            response.getOverview(),
                            response.getUrl(),
                            response.getImagePath(),
                            response.getType()
                    );
                }
            }

            detailMovieResult.postValue(movie);
        });

        return detailMovieResult;
    }

    @Override
    public LiveData<FilmEntity> getDetailShow(final String title) {
        MutableLiveData<FilmEntity> detailShowResult = new MutableLiveData<>();

        remoteDataSource.getAllShows(showResponses -> {
            FilmEntity show = null;
            for (FilmResponse response : showResponses) {
                if (response.getTitle().equals(title)) {
                    show = new FilmEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getYear(),
                            response.getGenres(),
                            response.getDuration(),
                            response.getRating(),
                            response.getOverview(),
                            response.getUrl(),
                            response.getImagePath(),
                            response.getType()
                    );
                }
            }

            detailShowResult.postValue(show);
        });

        return detailShowResult;
    }
}
