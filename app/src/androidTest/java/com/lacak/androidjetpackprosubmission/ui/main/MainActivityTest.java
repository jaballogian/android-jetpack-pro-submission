package com.lacak.androidjetpackprosubmission.ui.main;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private List<FilmEntity> sampleMoviesList = MoviesListDataGenerator.generateMoviesListData();

    @Rule
    public ActivityScenarioRule activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void loadMovies(){
        onView(withId(R.id.recyler_view_film)).check(matches(isDisplayed()));
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.scrollToPosition(sampleMoviesList.size()/2 - 1)); // HALF INDEX = INDEX 4
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.scrollToPosition(sampleMoviesList.size() - 1)); // LAST INDEX = INDEX 9
    }

    @Test
    public void loadDetailMovie(){
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_view_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_title)).check(matches(withText(sampleMoviesList.get(0).getTitle())));
        onView(withId(R.id.text_view_genres)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_genres)).check(matches(withText(sampleMoviesList.get(0).getGenres())));
        onView(withId(R.id.text_view_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_year)).check(matches(withText(sampleMoviesList.get(0).getYear())));
        onView(withId(R.id.text_view_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_rating)).check(matches(withText(sampleMoviesList.get(0).getRating())));
        onView(withId(R.id.text_view_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_duration)).check(matches(withText(sampleMoviesList.get(0).getDuration())));
        onView(withId(R.id.text_view_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_overview)).check(matches(withText(sampleMoviesList.get(0).getOverview())));
    }

}