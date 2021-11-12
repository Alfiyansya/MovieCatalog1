package com.alfian.moviecatalog1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfian.moviecatalog1.R
import com.alfian.moviecatalog1.data.movie.Movie
import com.alfian.moviecatalog1.databinding.ItemCatalogBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var listMovie = ArrayList<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemCatalogBinding =
            ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemCatalogBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMovie[position]) }
    }

    override fun getItemCount(): Int = listMovie.size
    private lateinit var onItemClickCallback : OnItemMovieClickCallback
    class ViewHolder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(itemPoster)
                itemTitle.text = movie.title
            }

        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemMovieClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    fun setMovies(movies: List<Movie>) {
        if (movies.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }


}