package com.example.barappkotlin.data

interface DataListener<T> {
    fun onData(data:T)
    fun onError(error:String?)
}