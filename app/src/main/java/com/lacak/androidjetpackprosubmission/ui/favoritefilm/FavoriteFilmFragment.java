package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lacak.androidjetpackprosubmission.databinding.FragmentFavoriteFilmBinding;

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
        }
    }
}