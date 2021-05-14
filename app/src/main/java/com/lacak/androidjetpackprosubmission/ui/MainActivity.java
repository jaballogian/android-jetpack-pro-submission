package com.lacak.androidjetpackprosubmission.ui;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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

        ViewPager viewPager = activityMainBinding.viewPager;
        TabLayout tabLayout = activityMainBinding.tabs;

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);

        viewPager.setAdapter(sectionsPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))));

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}