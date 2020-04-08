package com.example.movied


import com.example.movied.models.Movie
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    /**
     * complete API for top_rated: https://api.themoviedb.org/3/movie/top_rated?api_key=336cd47c524cba240450ba27ac6a0b84
     * complete API for upcoming: https://api.themoviedb.org/3/movie/upcoming?api_key=336cd47c524cba240450ba27ac6a0b84
     */
    @GET("top_rated")
    fun getTopRatedMovies(@Query("api_key") api_key:String): Call<Movie>

    @GET("upcoming")
    fun getUpcomingMovies(@Query("api_key") api_key:String): Call<Movie>
}