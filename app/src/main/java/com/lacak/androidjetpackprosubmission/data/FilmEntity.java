package com.lacak.androidjetpackprosubmission.data;

public class FilmEntity {
    private String title, year, genres, duration, rating, overview, url, imagePath;

    public String getTitle() {
        return title;
    }

    public FilmEntity(String title, String year, String genres, String duration, String rating, String overview, String url, String imagePath){
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.duration = duration;
        this.rating = rating;
        this.overview = overview;
        this.url = url;
        this.imagePath = imagePath;
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
}
