package com.lacak.androidjetpackprosubmission.ui.favorite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lacak.androidjetpackprosubmission.ui.favoritefilm.FavoriteFilmFragment;

public class FavoriteSectionPagerAdapter extends FragmentStateAdapter {

    public FavoriteSectionPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FavoriteFilmFragment.newInstance(position + 1);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
