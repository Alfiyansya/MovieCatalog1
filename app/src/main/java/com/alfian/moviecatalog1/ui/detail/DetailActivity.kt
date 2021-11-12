package com.alfian.moviecatalog1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alfian.moviecatalog1.R
import com.alfian.moviecatalog1.data.movie.Movie
import com.alfian.moviecatalog1.data.tvshow.TvShow
import com.alfian.moviecatalog1.databinding.ActivityDetailBinding
import com.alfian.moviecatalog1.util.DataDummy.MOVIE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val id = intent.getIntExtra(EXTRA_ID, 0)
        viewModel.setId(id)
        val key = intent.getStringExtra(EXTRA_KEY)
        if (key == MOVIE) {
            setUpDataMovie(viewModel.getMovie())
        } else {
            setUpDataTvShow(viewModel.getTvShow())
        }
    }

    private fun setUpDataMovie(movie: Movie?) {
        with(binding) {
            this?.detailPoster?.let {
                Glide.with(this@DetailActivity)
                    .load(movie?.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(it)
            }

            this?.detailTitle?.text = movie?.title
            this?.detailGenre?.text = movie?.genre
            this?.detailOverviewValue?.text = movie?.description
        }
    }

    private fun setUpDataTvShow(tvShow: TvShow?) {
        with(binding) {
            this?.detailPoster?.let {
                Glide.with(this@DetailActivity)
                    .load(tvShow?.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(it)
            }
            this?.detailTitle?.text = tvShow?.name
            this?.detailGenre?.text = tvShow?.genre
            this?.detailOverviewValue?.text = tvShow?.description
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_ID = "id"
        const val EXTRA_KEY = "key"
    }
}