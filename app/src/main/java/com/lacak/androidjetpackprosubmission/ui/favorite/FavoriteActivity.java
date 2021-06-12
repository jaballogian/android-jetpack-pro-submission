package com.lacak.androidjetpackprosubmission.ui.favorite;

import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.databinding.ActivityFavoriteBinding;

public class FavoriteActivity extends AppCompatActivity {

    private ActivityFavoriteBinding activityFavoriteBinding;

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.movies,
            R.string.tv_shows
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFavoriteBinding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(activityFavoriteBinding.getRoot());

        ViewPager2 viewPager2 = activityFavoriteBinding.viewPager2;
        TabLayout tabLayout = activityFavoriteBinding.tabs;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.favorite));
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.light_blue_a400)));

        FavoriteSectionPagerAdapter favoriteSectionPagerAdapter = new FavoriteSectionPagerAdapter(this);

        viewPager2.setAdapter(favoriteSectionPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position])))).attach();
    }
}