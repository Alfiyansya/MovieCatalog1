package com.alfian.moviecatalog1.ui.catalog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatalogViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CatalogViewModel
    @Before
    fun setUp(){
        viewModel = CatalogViewModel()
    }
    @Test
    fun getMovies() {
        val movie = viewModel.movies.value
        assertNotNull(movie)
        assertEquals(10,movie?.size)
    }

    @Test
    fun getTvShows() {
        val tvShow = viewModel.tvShows.value
        assertNotNull(tvShow)
        assertEquals(10,tvShow?.size)
    }
}