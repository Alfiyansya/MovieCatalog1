package com.alfian.moviecatalog1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfian.moviecatalog1.R
import com.alfian.moviecatalog1.data.tvshow.TvShow
import com.alfian.moviecatalog1.databinding.ItemCatalogBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {
    private var listTvShow = ArrayList<TvShow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCatalogBinding =
            ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemCatalogBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listTvShow[position]) }
    }

    override fun getItemCount(): Int = listTvShow.size
    private lateinit var onItemClickCallback : OnItemTvShowClickCallback
    class ViewHolder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(itemPoster)
                itemTitle.text = tvShow.name
            }
        }
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemTvShowClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    fun setTvShows(tvShows: List<TvShow>) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }
}