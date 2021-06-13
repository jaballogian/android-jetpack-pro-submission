package com.lacak.androidjetpackprosubmission.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FavoriteFilmEntity;

import java.util.List;

@Dao
public interface FavoriteFilmDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFilm(FavoriteFilmEntity favoriteFilmEntity);

    @Delete()
    void deleteFilm(FavoriteFilmEntity favoriteFilmEntity);

    @Query("select * from filmTable where type = 'movie'")
    LiveData<List<FavoriteFilmEntity>> getAllFavoriteMovies();

    @Query("select * from filmTable where type = 'show'")
    LiveData<List<FavoriteFilmEntity>> getAllFavoriteShows();
}
