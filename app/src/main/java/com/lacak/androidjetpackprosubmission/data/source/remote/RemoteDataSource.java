package com.lacak.androidjetpackprosubmission.data.source.remote;

import android.os.Handler;
import android.os.Looper;

import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;
import com.lacak.androidjetpackprosubmission.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final long SERVICE_LATENCY_IN_MILLIS = 1000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public void getAllMovies(LoadMoviesCallback callback) {
        handler.postDelayed(() -> callback.onAllMoviesReceived(jsonHelper.loadMoviesList()), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllShows(LoadShowsCallback callback) {
        handler.postDelayed(() -> callback.onAllShowsReceived(jsonHelper.loadShowsList()), SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMoviesCallback {
        void onAllMoviesReceived(List<FilmResponse> movieResponses);
    }

    public interface LoadShowsCallback {
        void onAllShowsReceived(List<FilmResponse> showResponses);
    }
}
