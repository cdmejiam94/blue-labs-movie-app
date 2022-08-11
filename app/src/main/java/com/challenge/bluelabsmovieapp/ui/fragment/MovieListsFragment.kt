package com.challenge.bluelabsmovieapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.challenge.bluelabsmovieapp.R
import com.challenge.bluelabsmovieapp.databinding.FragmentMovieListsBinding

class MovieListsFragment : Fragment() {

//    private lateinit var logInViewModel: LogInViewModel

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

        /*logInViewModel = ViewModelProviders.of(
            this,
            LogInViewModelFactory(requireActivity().application, ApiController())
        )[LogInViewModel::class.java]*/

        return binding.root
    }
}