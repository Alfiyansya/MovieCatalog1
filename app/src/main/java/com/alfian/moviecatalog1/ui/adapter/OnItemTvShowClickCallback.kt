package com.alfian.moviecatalog1.ui.adapter

import com.alfian.moviecatalog1.data.tvshow.TvShow

interface OnItemTvShowClickCallback {
    fun onItemClicked(tvShow : TvShow)
}