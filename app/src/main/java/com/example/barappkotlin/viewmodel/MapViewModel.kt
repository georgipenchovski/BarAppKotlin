package com.example.barappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barappkotlin.data.DataListener
import com.example.barappkotlin.data.NetworkManager
import com.example.barappkotlin.model.BarModel

class MapViewModel : ViewModel(), DataListener<List<BarModel>> {

    val onBarsLoadedEvent = MutableLiveData<List<BarModel>>()
    val onErrorEvent = MutableLiveData<String>()

    override fun onData(data: List<BarModel>) {
        onBarsLoadedEvent.value = data
    }

    override fun onError(error: String?) {
        error?.let {
            onErrorEvent.value = it
        }
    }

    fun loadBars(lat: Double, long: Double) {
        NetworkManager.getNearbyBars(lat, long, this)
    }
}