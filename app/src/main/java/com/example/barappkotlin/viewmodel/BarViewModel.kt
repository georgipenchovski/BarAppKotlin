package com.example.barappkotlin.viewmodel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barappkotlin.data.DataListener
import com.example.barappkotlin.data.NetworkManager
import com.example.barappkotlin.model.BarItem
import com.example.barappkotlin.model.BarModel

class BarViewModel : ViewModel(), DataListener<List<BarModel>> {

    val onBarsLoadedEvent = MutableLiveData<List<BarItem>>()
    val onErrorEvent = MutableLiveData<String>()

    override fun onData(data: List<BarModel>) {
        onBarsLoadedEvent.value = data.map { BarItem(it.name) }
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