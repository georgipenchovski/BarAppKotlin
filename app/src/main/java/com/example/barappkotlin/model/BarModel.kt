package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class BarModel(
    @SerializedName("geometry")
    @Expose
    var geometry: GeometryModel,
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("types")
    @Expose
    var types: List<String> = ArrayList(),
    @SerializedName("vicinity")
    @Expose
    var vicinity: String
)

