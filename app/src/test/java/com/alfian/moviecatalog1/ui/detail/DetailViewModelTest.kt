package com.alfian.moviecatalog1.ui.detail

import com.alfian.moviecatalog1.util.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest{
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id
    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setId(movieId)
        viewModel.setId(tvShowId)
    }
    @Test
    fun getMovie(){
        viewModel.setId(dummyMovie.id)
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.imagePath, movie.imagePath)
    }
    @Test
    fun getTvShow(){
        viewModel.setId(dummyTvShow.id)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.name, tvShow.name)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.description, tvShow.description)
        assertEquals(dummyTvShow.imagePath, tvShow.imagePath)
    }
}