package com.lacak.androidjetpackprosubmission.utils;

import android.content.Context;

import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<FilmResponse> loadMoviesList() {
        ArrayList<FilmResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("MovieResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movie = listArray.getJSONObject(i);

                    String title = movie.getString("title");
                    String year = movie.getString("year");
                    String genres = movie.getString("genres");
                    String duration = movie.getString("duration");
                    String rating = movie.getString("rating");
                    String overview = movie.getString("overview");
                    String url = movie.getString("url");
                    String imagePath = movie.getString("imagePath");

                    FilmResponse FilmResponse = new FilmResponse(title, year, genres, duration, rating, overview, url, imagePath);
                    list.add(FilmResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FilmResponse> loadShowsList() {
        ArrayList<FilmResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("ShowResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("shows");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject show = listArray.getJSONObject(i);

                    String title = show.getString("title");
                    String year = show.getString("year");
                    String genres = show.getString("genres");
                    String duration = show.getString("duration");
                    String rating = show.getString("rating");
                    String overview = show.getString("overview");
                    String url = show.getString("url");
                    String imagePath = show.getString("imagePath");

                    FilmResponse FilmResponse = new FilmResponse(title, year, genres, duration, rating, overview, url, imagePath);
                    list.add(FilmResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
