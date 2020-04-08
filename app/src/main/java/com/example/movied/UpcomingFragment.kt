package com.example.movied

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movied.adapters.MovieAdapter
import kotlinx.android.synthetic.main.fragment_upcoming.recyclerview

class UpcomingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_upcoming, container, false)

        var viewModel= ViewModelProvider(this).get(UpcomingViewModel::class.java)

        viewModel.getUpcomingMovies().observe(this, Observer {

            var adapter= MovieAdapter(viewModel.movielist!!.value)
            recyclerview.adapter=adapter
            recyclerview.layoutManager= LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        })

        return view
    }

}

