package com.challenge.bluelabsmovieapp.ui.listeners

import com.challenge.bluelabsmovieapp.service.response.Result

interface CustomMovieListener {
    fun getSelectedItemDocId(result: Result)
}