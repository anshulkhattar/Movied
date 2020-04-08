package com.example.movied

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movied.models.Movie
import com.example.movied.models.MovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private var mRetrofit: Retrofit? = null
    private var mApiService:ApiInterface?=null
    var api_key="336cd47c524cba240450ba27ac6a0b84"
    //var movieList=MutableLiveData<ArrayList<MovieDetails>>()

    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return this.mRetrofit!!
        }
}