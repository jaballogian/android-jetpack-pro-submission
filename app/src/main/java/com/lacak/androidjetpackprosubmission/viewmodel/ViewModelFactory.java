package com.lacak.androidjetpackprosubmission.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lacak.androidjetpackprosubmission.data.source.MainRepository;
import com.lacak.androidjetpackprosubmission.di.Injection;
import com.lacak.androidjetpackprosubmission.ui.detail.DetailViewModel;
import com.lacak.androidjetpackprosubmission.ui.film.FilmViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private static volatile ViewModelFactory INSTANCE;

    private final MainRepository mainRepository;

    private ViewModelFactory(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
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
            return (T) new DetailViewModel(mainRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
