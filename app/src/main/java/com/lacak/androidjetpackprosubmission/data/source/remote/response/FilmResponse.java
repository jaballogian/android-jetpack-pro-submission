package com.lacak.androidjetpackprosubmission.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmResponse implements Parcelable {
    private String title, year, genres, duration, rating, overview, url, imagePath;

    public FilmResponse(String title, String year, String genres, String duration, String rating, String overview, String url, String imagePath) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.duration = duration;
        this.rating = rating;
        this.overview = overview;
        this.url = url;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(genres);
        dest.writeString(duration);
        dest.writeString(rating);
        dest.writeString(overview);
        dest.writeString(url);
        dest.writeString(imagePath);
    }

    protected FilmResponse(Parcel in) {
        title = in.readString();
        year = in.readString();
        genres = in.readString();
        duration = in.readString();
        rating = in.readString();
        overview = in.readString();
        url = in.readString();
        imagePath = in.readString();
    }

    public static final Creator<FilmResponse> CREATOR = new Creator<FilmResponse>() {
        @Override
        public FilmResponse createFromParcel(Parcel in) {
            return new FilmResponse(in);
        }

        @Override
        public FilmResponse[] newArray(int size) {
            return new FilmResponse[size];
        }
    };
}