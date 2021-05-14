package com.lacak.androidjetpackprosubmission.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lacak.androidjetpackprosubmission.ui.film.FilmFragment;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FilmFragment.newInstance(position + 1);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
