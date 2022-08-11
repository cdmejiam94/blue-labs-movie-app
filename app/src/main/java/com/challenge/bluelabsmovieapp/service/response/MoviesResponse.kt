package com.challenge.bluelabsmovieapp.service.response

import com.google.gson.annotations.SerializedName

class MoviesResponse {
    @SerializedName("page") var page : String = ""
    @SerializedName("results") var results : List<Result> = listOf()

    constructor()

    constructor(page: String, results: List<Result>) {
        this.page = page
        this.results = results
    }


}