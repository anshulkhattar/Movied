package com.example.movied.models

import com.example.movied.models.MovieDetails
import com.google.gson.annotations.SerializedName

data class Movie (

    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val total_results : Int,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("results") val results : ArrayList<MovieDetails>
)