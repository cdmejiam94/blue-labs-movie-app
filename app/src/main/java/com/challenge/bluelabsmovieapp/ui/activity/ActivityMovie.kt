package com.challenge.bluelabsmovieapp.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.challenge.bluelabsmovieapp.R
import com.challenge.bluelabsmovieapp.databinding.ActivityMainBinding
import com.challenge.bluelabsmovieapp.ui.fragment.AboutFragment
import com.challenge.bluelabsmovieapp.ui.fragment.MovieListsFragment

class ActivityMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        replaceFragment(MovieListsFragment.newInstance(), "HomeFragment")

        binding.bottomNavigationMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(MovieListsFragment.newInstance(), "HomeFragment")
                R.id.about -> replaceFragment(AboutFragment.newInstance(), "AboutFragment")
                else -> Toast.makeText(application, "Error!", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    fun replaceFragment(newInstance: Fragment, tag: String) {
        val manager : FragmentManager = supportFragmentManager
        val fragment_transaction : FragmentTransaction = manager.beginTransaction()
        fragment_transaction.replace(R.id.frame_layout, newInstance, tag)
        fragment_transaction.commit()
    }
}