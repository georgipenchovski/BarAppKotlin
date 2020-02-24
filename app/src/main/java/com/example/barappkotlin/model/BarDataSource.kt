package com.example.barappkotlin.model

import com.example.barappkotlin.data.OperationCallback

interface BarDataSource {

    fun retrieveBars(callback: OperationCallback<BarModel>)
    fun cancel()
}