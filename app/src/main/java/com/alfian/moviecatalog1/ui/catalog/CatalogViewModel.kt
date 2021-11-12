package com.alfian.moviecatalog1.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alfian.moviecatalog1.data.movie.Movie
import com.alfian.moviecatalog1.data.tvshow.TvShow
import com.alfian.moviecatalog1.util.DataDummy

class CatalogViewModel : ViewModel() {
    private var _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>> = _movies
    private var _tvShows = MutableLiveData<List<TvShow>>()
    val tvShows : LiveData<List<TvShow>> = _tvShows
    init {
        getMovie()
        getTvShow()
    }
    private fun getTvShow() : LiveData<List<TvShow>> {
        val tvShows = DataDummy.generateDummyTvShows()
        _tvShows.value = tvShows
        return _tvShows
    }
    private fun getMovie() : LiveData<List<Movie>> {
        val movies = DataDummy.generateDummyMovies()
        _movies.value = movies
        return _movies

    }
}