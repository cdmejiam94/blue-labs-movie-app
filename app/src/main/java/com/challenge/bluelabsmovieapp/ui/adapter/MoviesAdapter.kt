package com.challenge.bluelabsmovieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.bluelabsmovieapp.R
import com.challenge.bluelabsmovieapp.service.response.Result
import com.challenge.bluelabsmovieapp.ui.listeners.CustomMovieListener

class MoviesAdapter (
    val list: List<Result>,
    val listener: CustomMovieListener? = null,
)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCard(list[position])

        holder.itemView.setOnClickListener {
            listener?.getSelectedItemDocId(list[position])
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindCard(result: Result) {
            itemView.findViewById<TextView>(R.id.rvTitle).text = result.title
            itemView.findViewById<TextView>(R.id.rvVoteAverage).text = result.vote_average.toString()
        }
    }
}