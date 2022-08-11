package com.challenge.bluelabsmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.compose.ui.text.toLowerCase
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.bluelabsmovieapp.R
import com.challenge.bluelabsmovieapp.controller.ApiController
import com.challenge.bluelabsmovieapp.databinding.FragmentMovieListsBinding
import com.challenge.bluelabsmovieapp.service.response.MoviesResponse
import com.challenge.bluelabsmovieapp.service.response.Result
import com.challenge.bluelabsmovieapp.ui.adapter.MoviesAdapter
import com.challenge.bluelabsmovieapp.ui.listeners.CustomMovieListener
import com.challenge.bluelabsmovieapp.viewmodel.MovieListsViewModel
import com.challenge.bluelabsmovieapp.viewmodel.MovieListsViewModelFactory
import java.time.Duration
import java.util.*
import kotlin.collections.ArrayList

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

        binding.sbTopMovies.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                filterListTM(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

        binding.sbOnCinemas.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                filterListOC(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

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

    private fun filterListTM(query: String) {
        var filteredItemList: ArrayList<Result> = arrayListOf()
        for (item in movieListsViewModel.getTopMoviesLiveDataContent()?.results!!) {
            if (item.title!!.contains(query)){
                filteredItemList.add(item)
            }
        }

        if (filteredItemList.isEmpty()){
            Toast.makeText(requireContext().applicationContext,"No se encuentra pelicula, busque de nuevo",Toast.LENGTH_SHORT).show()
        } else {
            var topMovies: MoviesResponse? = MoviesResponse("1", filteredItemList)
            movieListsViewModel.topMoviesListData.postValue(topMovies)
        }
    }

    private fun filterListOC(query: String) {
        var filteredOCItemList: ArrayList<Result> = arrayListOf()
        for (item in movieListsViewModel.getOnCinemasLiveDataContent()?.results!!) {
            if (item.title!!.contains(query)){
                filteredOCItemList.add(item)
            }
        }

        if (filteredOCItemList.isEmpty()){
            Toast.makeText(requireContext().applicationContext,"No se encuentra pelicula, busque de nuevo",Toast.LENGTH_SHORT).show()
        } else {
            var onCinemas: MoviesResponse? = MoviesResponse("1", filteredOCItemList)
            movieListsViewModel.onCinemasMoviesListData.postValue(onCinemas)
        }
    }

    override fun getSelectedItemDocId(result: Result) {

    }
}