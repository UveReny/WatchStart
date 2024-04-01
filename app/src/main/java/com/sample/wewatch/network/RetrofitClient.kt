package com.sample.wewatch.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // https://www.omdbapi.com/?apikey=1dbc7755&s=in%20a&y=2022&page=2
    // https://omdbapi.com/?apikey=1dbc7755&s=Dud

    const val API_KEY = "1dbc7755"
    const val TMDB_BASE_URL = "https://www.omdbapi.com/"
    const val TMDB_IMAGEURL = ""

  val moviesApi = Retrofit.Builder()
      .baseUrl(TMDB_BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
      .create(RetrofitInterface::class.java)
}
