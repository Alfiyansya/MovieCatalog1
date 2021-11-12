package com.alfian.moviecatalog1.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.alfian.moviecatalog1.R
import com.alfian.moviecatalog1.util.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies(){
        Espresso.onView(withId(R.id.rv_catalog))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_catalog)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
        Espresso.onView(withId(R.id.rv_catalog)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.detail_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_title))
            .check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        Espresso.onView(withId(R.id.detail_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_genre))
            .check(ViewAssertions.matches(withText(dummyMovie[0].genre)))
        Espresso.onView(withId(R.id.detail_overview_value))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_overview_value))
            .check(ViewAssertions.matches(withText(dummyMovie[0].description)))
        Espresso.onView(withId(R.id.detail_scroll_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_scroll_view))
            .perform(swipeUp())
    }

    @Test
    fun loadTvShow(){
        Espresso.onView(withText("TvShow")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_catalog))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_catalog)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
        Espresso.onView(withId(R.id.rv_catalog)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.detail_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_title))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].name)))
        Espresso.onView(withId(R.id.detail_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_genre))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].genre)))
        Espresso.onView(withId(R.id.detail_overview_value))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_overview_value))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].description)))
        Espresso.onView(withId(R.id.detail_scroll_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.detail_scroll_view))
            .perform(swipeUp())
    }
}