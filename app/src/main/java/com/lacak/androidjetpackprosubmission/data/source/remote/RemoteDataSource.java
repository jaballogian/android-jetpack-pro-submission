package com.lacak.androidjetpackprosubmission.data.source.remote;

import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;
import com.lacak.androidjetpackprosubmission.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public List<FilmResponse> getAllMovies() {
        return jsonHelper.loadMoviesList();
    }

    public List<FilmResponse> getAllShows() {
        return jsonHelper.loadShowsList();
    }
}
