package com.lacak.androidjetpackprosubmission.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoriteFilmTable")
public class FavoriteFilmEntity implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "year")
    private String year;

    @ColumnInfo(name = "genres")
    private String genres;

    @ColumnInfo(name = "duration")
    private String duration;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "imagePath")
    private String imagePath;

    @ColumnInfo(name = "type")
    private String type;

    public FavoriteFilmEntity(
            int id,
            String title,
            String year,
            String genres,
            String duration,
            String rating,
            String overview,
            String url,
            String imagePath,
            String type
    ){
        this.id = id;
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.duration = duration;
        this.rating = rating;
        this.overview = overview;
        this.url = url;
        this.imagePath = imagePath;
        this.type = type;
    }

    protected FavoriteFilmEntity(Parcel in) {
        id = in.readInt();
        title = in.readString();
        year = in.readString();
        genres = in.readString();
        duration = in.readString();
        rating = in.readString();
        overview = in.readString();
        url = in.readString();
        imagePath = in.readString();
        type = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(genres);
        dest.writeString(duration);
        dest.writeString(rating);
        dest.writeString(overview);
        dest.writeString(url);
        dest.writeString(imagePath);
        dest.writeString(type);
    }

    public static final Creator<FavoriteFilmEntity> CREATOR = new Creator<FavoriteFilmEntity>() {
        @Override
        public FavoriteFilmEntity createFromParcel(Parcel in) {
            return new FavoriteFilmEntity(in);
        }

        @Override
        public FavoriteFilmEntity[] newArray(int size) {
            return new FavoriteFilmEntity[size];
        }
    };
}
