package com.lacak.androidjetpackprosubmission.ui.film;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.FragmentFilmBinding;
import com.lacak.androidjetpackprosubmission.ui.detail.DetailActivity;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

import java.util.List;

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

            ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(getActivity(), getActivity().getApplication());
            FilmViewModel filmViewModel = new ViewModelProvider(this, viewModelFactory).get(FilmViewModel.class);

            fragmentFilmBinding.progressBar.setVisibility(View.VISIBLE);

            // ADD DATA TO RECYLER VIEW BASED ON SELECTED TAB
            if(index == 1){
                filmViewModel.getMoviesListData().observe(this, movies -> {
                    fragmentFilmBinding.progressBar.setVisibility(View.GONE);
                    addDataToRecylerView(movies);
                });
            }
            else if(index == 2){
                filmViewModel.getShowsListData().observe(this, shows -> {
                    fragmentFilmBinding.progressBar.setVisibility(View.GONE);
                    addDataToRecylerView(shows);
                });
            }
        }
    }

    private void addDataToRecylerView(List<FilmEntity> inputList){
        FilmAdapter filmAdapter = new FilmAdapter(getContext());
        filmAdapter.setListFilms(inputList);
        filmAdapter.notifyDataSetChanged();

        fragmentFilmBinding.recylerViewFilm.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentFilmBinding.recylerViewFilm.setHasFixedSize(true);
        fragmentFilmBinding.recylerViewFilm.setAdapter(filmAdapter);

        filmAdapter.setOnItemClickCallback(new FilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(FilmEntity filmEntity) {
                Intent moveToDetailActivity = new Intent(getContext(), DetailActivity.class);
                moveToDetailActivity.putExtra(DetailActivity.EXTRA_FILM, filmEntity);
                startActivityForResult(moveToDetailActivity, DetailActivity.REQUEST_ADD);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("FilmFragment", "requestCode: " + requestCode + ", resultCode: " + resultCode + ", data: " + data);
        if(data != null) {
            if(requestCode == DetailActivity.REQUEST_ADD) {
                if(resultCode == DetailActivity.RESULT_ADD) {
                    Toast.makeText(getContext(), getString(R.string.added_to_favorite_list), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}