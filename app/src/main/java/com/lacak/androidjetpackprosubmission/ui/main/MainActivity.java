package com.lacak.androidjetpackprosubmission.ui.main;

import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.home));
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.light_blue_a400)));

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);

        viewPager2.setAdapter(sectionsPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position])))).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.goToFavoriteActivity) {

        }

        return super.onOptionsItemSelected(item);
    }
}