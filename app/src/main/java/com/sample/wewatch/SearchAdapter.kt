package com.sample.wewatch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.wewatch.model.Movie
import com.squareup.picasso.Picasso

class SearchAdapter(
  var movieList: List<Movie>,
  var context: Context,
  var listener: SearchActivity.RecyclerItemListener
): RecyclerView.Adapter<SearchAdapter.SearchMoviesHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_movie_details, parent,
      false)

    val viewHolder = SearchMoviesHolder(view)
    view.setOnClickListener { viewItem -> listener.onItemClick(
      viewItem, viewHolder.adapterPosition) }
    return viewHolder
  }

  override fun onBindViewHolder(holder: SearchMoviesHolder, position: Int) {
    holder.titleTextView.text = movieList[position].title
    holder.releaseDateTextView.text = movieList[position].getReleaseYearFromDate()
    holder.overviewTextView.text = movieList[position].overview

    if (movieList[position].posterPath != "N/A") {
      Picasso.get().load("" + movieList[position].posterPath).into(holder.movieImageView)
    }
  }

  override fun getItemCount(): Int {
    return movieList.size
  }

  fun getItemAtPosition(pos: Int): Movie {
    return movieList[pos]
  }

  inner class SearchMoviesHolder(view: View) : RecyclerView.ViewHolder(view) {

    var titleTextView: TextView = view.findViewById(R.id.title_textview)
    var overviewTextView: TextView = view.findViewById(R.id.overview_textview)
    var releaseDateTextView: TextView = view.findViewById(R.id.release_date_textview)
    var movieImageView: ImageView = view.findViewById(R.id.movie_imageview)

    init {
      view.setOnClickListener { viewItem: View ->
        listener.onItemClick(viewItem, adapterPosition)
      }
    }
  }
}
