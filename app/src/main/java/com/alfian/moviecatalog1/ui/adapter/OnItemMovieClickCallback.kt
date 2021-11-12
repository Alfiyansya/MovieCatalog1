package com.alfian.moviecatalog1.ui.adapter

import com.alfian.moviecatalog1.data.movie.Movie

interface OnItemMovieClickCallback {
    fun onItemClicked(movie : Movie)
}