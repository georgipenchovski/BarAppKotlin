package com.example.barappkotlin.model

import android.location.Location

data class BarItem(
    var name: String,
    var distance: Double,
    var location: Location
)
