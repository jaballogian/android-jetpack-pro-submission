package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.FragmentFavoriteFilmBinding;
import com.lacak.androidjetpackprosubmission.ui.favoritedetail.FavoriteDetailActivity;
import com.lacak.androidjetpackprosubmission.viewmodel.ViewModelFactory;

public class FavoriteFilmFragment extends Fragment {

    private static final String ARG_FAV_SECTION_NUMBER = "section_number";
    private FragmentFavoriteFilmBinding fragmentFavoriteFilmBinding;

    public static FavoriteFilmFragment newInstance(int index){
        FavoriteFilmFragment fragment = new FavoriteFilmFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_FAV_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavoriteFilmBinding = FragmentFavoriteFilmBinding.inflate(inflater, container, false);
        return fragmentFavoriteFilmBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_FAV_SECTION_NUMBER);

            ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(getActivity(), getActivity().getApplication());
            FavoriteFilmViewModel favoriteFilmViewModel = new ViewModelProvider(this, viewModelFactory).get(FavoriteFilmViewModel.class);

            fragmentFavoriteFilmBinding.progressBar.setVisibility(View.VISIBLE);

            // ADD DATA TO RECYLER VIEW BASED ON SELECTED TAB
            if(index == 1){
                favoriteFilmViewModel.getAllFavoriteMovies().observe(this, favoriteMovies -> {
                    fragmentFavoriteFilmBinding.progressBar.setVisibility(View.GONE);
                    addDataToRecylerView(favoriteMovies);
                });
            }
            else if(index == 2){
                favoriteFilmViewModel.getAllFavoriteShows().observe(this, favoriteShows -> {
                    fragmentFavoriteFilmBinding.progressBar.setVisibility(View.GONE);
                    addDataToRecylerView(favoriteShows);
                });
            }
        }
    }

    private void addDataToRecylerView(PagedList<FilmEntity> inputList) {
        FavoriteFilmAdapter favoriteFilmAdapter = new FavoriteFilmAdapter(getActivity());
        favoriteFilmAdapter.submitList(inputList);

        fragmentFavoriteFilmBinding.recylerViewFavoriteFilm.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentFavoriteFilmBinding.recylerViewFavoriteFilm.setHasFixedSize(true);
        fragmentFavoriteFilmBinding.recylerViewFavoriteFilm.setAdapter(favoriteFilmAdapter);

        favoriteFilmAdapter.setOnItemClickCallback(new FavoriteFilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(FilmEntity filmEntity) {
                Intent moveToFavoriteDetailActivity = new Intent(getContext(), FavoriteDetailActivity.class);
                moveToFavoriteDetailActivity.putExtra(FavoriteDetailActivity.EXTRA_FILM, filmEntity);
                startActivityForResult(moveToFavoriteDetailActivity, FavoriteDetailActivity.REQUEST_DELETE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            if(requestCode == FavoriteDetailActivity.REQUEST_DELETE) {
                if(resultCode == FavoriteDetailActivity.RESULT_DELETE) {
                    Toast.makeText(getContext(), getString(R.string.deleted_from_favorite_list), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}