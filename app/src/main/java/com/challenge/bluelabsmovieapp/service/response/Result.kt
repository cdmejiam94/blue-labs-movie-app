package com.challenge.bluelabsmovieapp.service.response

import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("poster_path")
    var poster_path: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("vote_average")
    var vote_average: Double? = null

    @SerializedName("id")
    var id: Int? = null

    constructor()

    constructor(poster_path: String?, title: String?, vote_average: Double?, id: Int?) {
        this.poster_path = poster_path
        this.title = title
        this.vote_average = vote_average
        this.id = id
    }

}