package com.example.movied

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movied.adapters.MovieAdapter
import com.example.movied.models.MovieDetails
import kotlinx.android.synthetic.main.fragment_top_rated.*


class TopRatedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_top_rated, container, false)

        //var viewModel=ViewModelProviders.of(requireActivity()).get(TopRatedViewModel::class.java)
        var viewModel= ViewModelProvider(this).get(TopRatedViewModel::class.java)

        //Toast.makeText(this.activity,"this is top rated",Toast.LENGTH_SHORT).show()
        viewModel.getTopRatedMovies().observe(this, Observer {



            //Toast.makeText(this,"this is top rated",Toast.LENGTH_SHORT).show()
            var adapter= MovieAdapter(viewModel.movielist!!.value)
            //Log.d("fds",viewModel.movielist?.value.toString())
            recyclerview.adapter=adapter
            recyclerview.layoutManager= LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        })

        return view
    }

}
