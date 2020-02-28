package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeometryModel(
    @SerializedName("location")
    @Expose
    var location: LocationModel
)

