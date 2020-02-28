package com.example.barappkotlin.data

import com.example.barappkotlin.model.BarCollection
import com.example.barappkotlin.model.BarModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    const val BASE_URL = "https://maps.googleapis.com/maps/"

    private const val RADIUS_NEARBY_BARS = 800

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: ApiService by lazy {
        retrofitBuilder.build().create(ApiService::class.java)
    }

    fun getNearbyBars(
        latitude: Double,
        longtitude: Double,
        dataListener: DataListener<List<BarModel>>
    ) {
        val call = apiService?.getNearbyPlaces(
            "bar",
            "$latitude,$longtitude", RADIUS_NEARBY_BARS
        )

        call?.enqueue(object : Callback<BarCollection?> {
            override fun onFailure(call: Call<BarCollection?>, t: Throwable) {
                t.localizedMessage?.let {
                    dataListener.onError(it)
                }
            }

            override fun onResponse(
                call: Call<BarCollection?>,
                response: Response<BarCollection?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.results.let {
                            dataListener.onData(it)
                        }
                    }
                }
            }

        })
    }
}