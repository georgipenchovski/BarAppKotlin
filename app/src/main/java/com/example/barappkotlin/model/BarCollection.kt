package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class BarCollection {
    @SerializedName("results")
    @Expose
    private var results: List<BarModel> = ArrayList()

    fun getResults(): List<BarModel>? {
        return results
    }

    fun setResults(results: List<BarModel>) {
        this.results = results
    }
}