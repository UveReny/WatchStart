package com.sample.wewatch.model

import android.app.Application
import io.reactivex.Observable
import kotlin.concurrent.thread


open class LocalDataSource(application: Application) {

  private val movieDao: MovieDao = TODO()
  open val allMovies: Observable<List<Movie>> = TODO()

  init {
    val db = LocalDatabase.getInstance(application)
    movieDao = db.movieDao()
    allMovies = movieDao.all
  }


  fun insert(movie: Movie) {
    thread {
      movieDao.insert(movie)
    }
  }

  fun delete(movie: Movie) {
    thread {
      movieDao.delete(movie.id)
    }
  }

  fun update(movie: Movie) {
    thread {
      movieDao.update(movie)
    }
  }

}