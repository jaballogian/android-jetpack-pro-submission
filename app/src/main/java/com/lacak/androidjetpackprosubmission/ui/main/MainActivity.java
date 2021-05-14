package com.lacak.androidjetpackprosubmission.ui.main;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.movies,
            R.string.tv_shows
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ViewPager2 viewPager2 = activityMainBinding.viewPager2;
        TabLayout tabLayout = activityMainBinding.tabs;

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);

        viewPager2.setAdapter(sectionsPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position])))).attach();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}