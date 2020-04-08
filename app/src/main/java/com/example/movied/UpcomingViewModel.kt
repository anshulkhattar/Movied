package com.example.movied

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.*
import com.example.movied.models.Movie
import com.example.movied.models.MovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {

    var movielist:MutableLiveData<ArrayList<MovieDetails>>?=null
    var mApiService: ApiInterface? = null



    fun getUpcomingMovies(): LiveData<ArrayList<MovieDetails>> {
        if (movielist == null) {

            movielist= MutableLiveData<ArrayList<MovieDetails>>()
            loadUpcomingRatedMovies()

        }
        return movielist as MutableLiveData<ArrayList<MovieDetails>>
    }

    fun loadUpcomingRatedMovies(){
        mApiService = RetrofitClient.client.create(ApiInterface::class.java)
        val call = mApiService!!.getUpcomingMovies(RetrofitClient.api_key)
        call.enqueue(object : Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>)
            {
                var mov=response.body()!!.results
                movielist!!.value=mov
                Log.d("valll", movielist!!.value.toString())
            }


            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(ContentValues.TAG, "Got error : " + t.localizedMessage)
            }
        })
    }
}