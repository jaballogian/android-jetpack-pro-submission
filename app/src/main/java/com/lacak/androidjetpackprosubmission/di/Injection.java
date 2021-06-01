package com.lacak.androidjetpackprosubmission.di;

import android.content.Context;

import com.lacak.androidjetpackprosubmission.data.MainRepository;
import com.lacak.androidjetpackprosubmission.data.source.remote.RemoteDataSource;
import com.lacak.androidjetpackprosubmission.utils.JsonHelper;

public class Injection {
    public static MainRepository provideRepository(Context context){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        return MainRepository.getInstance(remoteDataSource);
    }
}
