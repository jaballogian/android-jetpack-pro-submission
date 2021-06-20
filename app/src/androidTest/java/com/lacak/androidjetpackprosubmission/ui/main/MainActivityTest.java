package com.lacak.androidjetpackprosubmission.ui.main;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.lacak.androidjetpackprosubmission.R;
import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.utils.MoviesListDataGenerator;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private List<FilmEntity> sampleMoviesList = MoviesListDataGenerator.generateMoviesListData();

    @Rule
    public ActivityScenarioRule activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void loadMovies(){
        delayTwoSecond();
        onView(withId(R.id.recyler_view_film)).check(matches(isDisplayed()));
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.scrollToPosition(sampleMoviesList.size()/2 - 1)); // HALF INDEX = INDEX 4
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.scrollToPosition(sampleMoviesList.size() - 1)); // LAST INDEX = INDEX 9
    }

    @Test
    public void loadDetailMovieAtFirstIndex(){
        delayTwoSecond();
        int selectedIndex = 0;
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.actionOnItemAtPosition(selectedIndex, click()));
        delayTwoSecond();
        onView(withId(R.id.text_view_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_title)).check(matches(withText(sampleMoviesList.get(selectedIndex).getTitle())));
        onView(withId(R.id.text_view_genres)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_genres)).check(matches(withText(sampleMoviesList.get(selectedIndex).getGenres())));
        onView(withId(R.id.text_view_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_year)).check(matches(withText(sampleMoviesList.get(selectedIndex).getYear())));
        onView(withId(R.id.text_view_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_rating)).check(matches(withText(sampleMoviesList.get(selectedIndex).getRating())));
        onView(withId(R.id.text_view_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_duration)).check(matches(withText(sampleMoviesList.get(selectedIndex).getDuration())));
        onView(withId(R.id.text_view_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_overview)).check(matches(withText(sampleMoviesList.get(selectedIndex).getOverview())));
    }

    @Test
    public void loadDetailMovieAtLastIndex(){
        delayTwoSecond();
        int selectedIndex = sampleMoviesList.size() - 1;
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.actionOnItemAtPosition(selectedIndex, click()));
        delayTwoSecond();
        onView(withId(R.id.text_view_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_title)).check(matches(withText(sampleMoviesList.get(selectedIndex).getTitle())));
        onView(withId(R.id.text_view_genres)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_genres)).check(matches(withText(sampleMoviesList.get(selectedIndex).getGenres())));
        onView(withId(R.id.text_view_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_year)).check(matches(withText(sampleMoviesList.get(selectedIndex).getYear())));
        onView(withId(R.id.text_view_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_rating)).check(matches(withText(sampleMoviesList.get(selectedIndex).getRating())));
        onView(withId(R.id.text_view_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_duration)).check(matches(withText(sampleMoviesList.get(selectedIndex).getDuration())));
        onView(withId(R.id.text_view_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_overview)).check(matches(withText(sampleMoviesList.get(selectedIndex).getOverview())));
    }

    private void delayTwoSecond() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadFavoriteMovies() {
        delayTwoSecond();
        onView(withId(R.id.recyler_view_film)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        delayTwoSecond();
        onView(withId(R.id.floating_action_button_favorite)).perform(click());
        onView(withId(R.id.goToFavoriteActivity)).perform(click());
        onView(withId(R.id.recyler_view_favorite_film)).check(matches(isDisplayed()));
        onView(withId(R.id.recyler_view_favorite_film)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_view_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_genres)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_view_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.floating_action_button_delete)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}