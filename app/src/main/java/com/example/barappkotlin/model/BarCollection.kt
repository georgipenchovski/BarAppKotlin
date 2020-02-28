package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class BarCollection(
    @SerializedName("results")
    @Expose
    var results: List<BarModel> = ArrayList()
)

