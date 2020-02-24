package com.example.barappkotlin.data

import com.example.barappkotlin.model.BarModel

data class BarResponse(val status: Int?, val msg: String?, val data: List<BarModel>?) {
    fun isSuccess(): Boolean = (status == 200)
}