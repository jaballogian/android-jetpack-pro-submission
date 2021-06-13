package com.lacak.androidjetpackprosubmission.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FavoriteFilmEntity;

@Database(entities = {FavoriteFilmEntity.class}, version = 1, exportSchema = false)
public abstract class FavoriteFilmRoomDatabase extends RoomDatabase {
    public abstract FavoriteFilmDao favoriteFilmDao();

    private static volatile FavoriteFilmRoomDatabase INSTANCE;

    public static FavoriteFilmRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (FavoriteFilmRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        FavoriteFilmRoomDatabase.class, "favorite_film_database")
                        .build();
            }
        }
        return INSTANCE;
    }

}
