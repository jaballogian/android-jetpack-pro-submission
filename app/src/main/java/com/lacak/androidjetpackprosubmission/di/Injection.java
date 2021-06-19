package com.lacak.androidjetpackprosubmission.di;

import android.app.Application;
import android.content.Context;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.MainRepository;
import com.lacak.androidjetpackprosubmission.data.source.local.LocalDataSource;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmDao;
import com.lacak.androidjetpackprosubmission.data.source.local.room.FavoriteFilmRoomDatabase;
import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.utils.JsonHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Injection {
    public static MainRepository provideRepository(Context context){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        return MainRepository.getInstance(remoteDataSource);
    }

    public static FavoriteFilmRepository provideFavoriteFilmRepository(Application application){
        FavoriteFilmRoomDatabase favoriteFilmRoomDatabase = FavoriteFilmRoomDatabase.getDatabase(application);
        FavoriteFilmDao favoriteFilmDao = favoriteFilmRoomDatabase.favoriteFilmDao();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        LocalDataSource localDataSource = LocalDataSource.getInstance(favoriteFilmDao, executorService);
        return FavoriteFilmRepository.getInstance(localDataSource);
    }
}
