package com.example.barappkotlin.data

import com.example.barappkotlin.model.BarCollection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyAgyZuAj_jhJTZa5-7umraXyz1sHRlhNXk")
    fun getNearbyPlaces(
        @Query("type") type: String?, @Query(
            "location"
        ) location: String?, @Query("radius") radius: Int
    ): Call<BarCollection?>?
}