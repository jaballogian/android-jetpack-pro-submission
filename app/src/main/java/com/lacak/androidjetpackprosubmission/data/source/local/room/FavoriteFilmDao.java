package com.lacak.androidjetpackprosubmission.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;

@Dao
public interface FavoriteFilmDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFilm(FilmEntity filmEntity);

    @Delete()
    void deleteFilm(FilmEntity filmEntity);

    @Query("select * from favoriteFilmTable where type = 'movie'")
    DataSource.Factory<Integer, FilmEntity> getAllFavoriteMovies();

    @Query("select * from favoriteFilmTable where type = 'show'")
    DataSource.Factory<Integer, FilmEntity> getAllFavoriteShows();

    @Query("select * from favoriteFilmTable where type = 'movie' and id = :id")
    LiveData<FilmEntity> getDetailFavoriteMovie(int id);

    @Query("select * from favoriteFilmTable where type = 'show' and id = :id")
    LiveData<FilmEntity> getDetailFavoriteShow(int id);

}
