package com.example.barappkotlin.model

import android.location.Location

class BarItem {
    private var name: String? = null
    private var distance = 0.0
    private var location: Location? = null

    fun BarItem(
        barName: String?,
        location: Location?,
        barDistance: Double
    ) {
        name = barName
        this.location = location
        distance = barDistance
    }

    fun getName(): String? {
        return name
    }

    fun getDistance(): Double {
        return distance
    }

    fun getLocation(): Location? {
        return location
    }

    operator fun compareTo(barItem: BarItem): Int {
        return if (barItem.distance > distance) -1 else 1
    }
}