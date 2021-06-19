package com.lacak.androidjetpackprosubmission.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lacak.androidjetpackprosubmission.data.FavoriteFilmRepository;
import com.lacak.androidjetpackprosubmission.data.MainRepository;
import com.lacak.androidjetpackprosubmission.di.Injection;
import com.lacak.androidjetpackprosubmission.ui.detail.DetailViewModel;
import com.lacak.androidjetpackprosubmission.ui.favoritedetail.FavoriteDetailViewModel;
import com.lacak.androidjetpackprosubmission.ui.favoritefilm.FavoriteFilmViewModel;
import com.lacak.androidjetpackprosubmission.ui.film.FilmViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private static volatile ViewModelFactory INSTANCE;

    private final MainRepository mainRepository;
    private final FavoriteFilmRepository favoriteFilmRepository;
    private final Application application;

    private ViewModelFactory(MainRepository mainRepository, FavoriteFilmRepository favoriteFilmRepository, Application application) {
        this.mainRepository = mainRepository;
        this.favoriteFilmRepository = favoriteFilmRepository;
        this.application = application;
    }

    public static ViewModelFactory getInstance(Context context, Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(
                        Injection.provideRepository(context),
                        Injection.provideFavoriteFilmRepository(application),
                        application
                );
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(FilmViewModel.class)) {
            return (T) new FilmViewModel(mainRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(mainRepository, favoriteFilmRepository);
        } else if (modelClass.isAssignableFrom(FavoriteFilmViewModel.class)) {
            return (T) new FavoriteFilmViewModel(favoriteFilmRepository);
        } else if (modelClass.isAssignableFrom(FavoriteDetailViewModel.class)) {
            return (T) new FavoriteDetailViewModel(favoriteFilmRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
