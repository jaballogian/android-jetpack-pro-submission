package com.lacak.androidjetpackprosubmission.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.FragmentFilmBinding;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FragmentFilmBinding fragmentFilmBinding;

    public static FilmFragment newInstance(int index) {
        FilmFragment fragment = new FilmFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFilmBinding = FragmentFilmBinding.inflate(inflater, container, false);
        return fragmentFilmBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);

            if(index == 1){
                addMoviesDataToRecylerView();
            }
        }
    }

    private void addMoviesDataToRecylerView(){
        List<FilmEntity> listFilms = MoviesListDataGenerator.generateMoviesListData();

        FilmAdapter filmAdapter = new FilmAdapter();
        filmAdapter.setListFilms(listFilms);

        fragmentFilmBinding.recylerViewFilm.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentFilmBinding.recylerViewFilm.setHasFixedSize(true);
        fragmentFilmBinding.recylerViewFilm.setAdapter(filmAdapter);
    }
}