package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("lat")
    @Expose
    var lat: Double,
    @SerializedName("lng")
    @Expose
    var lng: Double
)

