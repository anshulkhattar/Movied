package com.example.movied.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movied.R
import com.example.movied.databinding.MovieDataBinding
import com.example.movied.models.MovieDetails
import com.squareup.picasso.Picasso


class MovieAdapter( private val movie: ArrayList<MovieDetails>?) : RecyclerView.Adapter<MovieAdapter.myViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)


        context=parent.context

        val layoutInflater= LayoutInflater.from(parent.context)

        val movieDataBinding: MovieDataBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.movie_card,parent,false)

        return myViewHolder(movieDataBinding)
    }

    override fun onBindViewHolder(holder:myViewHolder, position: Int) {
        var mov= movie?.get(position)
        if (mov != null) {
            holder.bindMovie(mov)
        }
    }

    override fun getItemCount(): Int {
        return movie!!.size
    }

    class myViewHolder(val movieDataBinding: MovieDataBinding) : RecyclerView.ViewHolder(movieDataBinding.root) {
        fun bindMovie(movieDetails: MovieDetails){
            movieDataBinding.movie=movieDetails
        }
    }
}