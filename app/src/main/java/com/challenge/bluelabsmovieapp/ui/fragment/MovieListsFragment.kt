package com.challenge.bluelabsmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.bluelabsmovieapp.R
import com.challenge.bluelabsmovieapp.controller.ApiController
import com.challenge.bluelabsmovieapp.databinding.FragmentMovieListsBinding
import com.challenge.bluelabsmovieapp.service.response.Result
import com.challenge.bluelabsmovieapp.ui.adapter.MoviesAdapter
import com.challenge.bluelabsmovieapp.ui.listeners.CustomMovieListener
import com.challenge.bluelabsmovieapp.viewmodel.MovieListsViewModel
import com.challenge.bluelabsmovieapp.viewmodel.MovieListsViewModelFactory

class MovieListsFragment : Fragment(), CustomMovieListener {

    private lateinit var movieListsViewModel: MovieListsViewModel

    companion object {
        fun newInstance() : Fragment {
            return  MovieListsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieListsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_lists,
            container,
            false
        )

        movieListsViewModel = ViewModelProviders.of(
            this,
            MovieListsViewModelFactory(ApiController())
        )[MovieListsViewModel::class.java]

        movieListsViewModel.topMoviesListData.observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.topMoviesRecycler.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = MoviesAdapter(it.results, this@MovieListsFragment, requireActivity())
                }
            }
        })

        movieListsViewModel.onCinemasMoviesListData.observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.onCinemasRecycler.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = MoviesAdapter(it.results, this@MovieListsFragment, requireActivity())
                }
            }
        })

        movieListsViewModel.getTopMovies()

        movieListsViewModel.getOnCinemasMovies()

        return binding.root
    }

    override fun getSelectedItemDocId(result: Result) {

    }
}