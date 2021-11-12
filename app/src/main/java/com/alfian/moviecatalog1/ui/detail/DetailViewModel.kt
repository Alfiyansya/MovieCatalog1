package com.alfian.moviecatalog1.ui.detail

import androidx.lifecycle.ViewModel
import com.alfian.moviecatalog1.data.movie.Movie
import com.alfian.moviecatalog1.data.tvshow.TvShow
import com.alfian.moviecatalog1.util.DataDummy

class DetailViewModel : ViewModel() {
    private var id : Int? = null
    fun setId(id:Int){
        this.id = id
    }
    fun getMovie(): Movie {
        lateinit var movie : Movie
        val movies = DataDummy.generateDummyMovies()
        for (mMovie in movies){
            if (mMovie.id == id) {
                movie = mMovie
            }
        }
        return movie
    }
    fun getTvShow(): TvShow {
        lateinit var tvShow : TvShow
        val tvShows = DataDummy.generateDummyTvShows()
        for (mTvShow in tvShows){
            if (mTvShow.id == id) {
                tvShow = mTvShow
            }
        }
        return tvShow
    }
}