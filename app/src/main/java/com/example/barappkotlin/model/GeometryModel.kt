package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeometryModel {
    @SerializedName("location")
    @Expose
    private var location: LocationModel? = null

    fun getLocation(): LocationModel? {
        return location
    }

    fun setLocation(location: LocationModel?) {
        this.location = location
    }
}