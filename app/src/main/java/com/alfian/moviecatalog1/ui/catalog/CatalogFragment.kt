package com.alfian.moviecatalog1.ui.catalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alfian.moviecatalog1.data.movie.Movie
import com.alfian.moviecatalog1.data.tvshow.TvShow
import com.alfian.moviecatalog1.databinding.FragmentCatalogBinding
import com.alfian.moviecatalog1.ui.adapter.MovieAdapter
import com.alfian.moviecatalog1.ui.adapter.OnItemMovieClickCallback
import com.alfian.moviecatalog1.ui.adapter.OnItemTvShowClickCallback
import com.alfian.moviecatalog1.ui.adapter.TvShowAdapter
import com.alfian.moviecatalog1.ui.detail.DetailActivity
import com.alfian.moviecatalog1.util.DataDummy.MOVIE
import com.alfian.moviecatalog1.util.DataDummy.TVSHOW


class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding
    private val catalogViewModel: CatalogViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        if (index == 1) {
            catalogViewModel.movies.observe(viewLifecycleOwner) { movies ->
                setUpDataMovie(movies)
            }
        } else {
            catalogViewModel.tvShows.observe(viewLifecycleOwner) { tvShows ->
                setUpDataTvShow(tvShows)

            }
        }
    }

    private fun setUpDataMovie(movies: List<Movie>) {
        val movieAdapter = MovieAdapter()
        movieAdapter.setMovies(movies)
        with(binding?.rvCatalog) {
            this?.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            this?.setHasFixedSize(true)
            this?.adapter = movieAdapter
        }
        movieAdapter.setOnItemClickCallback(object: OnItemMovieClickCallback {
            override fun onItemClicked(movie: Movie) {
                val intent = Intent(requireActivity(),DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
                intent.putExtra(DetailActivity.EXTRA_KEY, MOVIE)
                startActivity(intent)
            }

        })
    }

    private fun setUpDataTvShow(tvShows: List<TvShow>) {
        val tvShowAdapter = TvShowAdapter()
        tvShowAdapter.setTvShows(tvShows)
        with(binding?.rvCatalog){
            this?.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            this?.setHasFixedSize(true)
            this?.adapter = tvShowAdapter
        }
        tvShowAdapter.setOnItemClickCallback(object: OnItemTvShowClickCallback {
            override fun onItemClicked(tvShow: TvShow) {
                val intent = Intent(requireActivity(),DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ID,tvShow.id)
                intent.putExtra(DetailActivity.EXTRA_KEY, TVSHOW)
                startActivity(intent)
            }
        })
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section number"

        @JvmStatic
        fun newInstance(index: Int) =
            CatalogFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}