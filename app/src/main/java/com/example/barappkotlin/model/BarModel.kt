package com.example.barappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class BarModel {

    @SerializedName("geometry")
    @Expose
    private var geometry: GeometryModel? = null
    @SerializedName("id")
    @Expose
    private val id: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("types")
    @Expose
    private var types: List<String> = ArrayList()
    @SerializedName("vicinity")
    @Expose
    private var vicinity: String? = null

    fun getGeometry(): GeometryModel? {
        return geometry
    }

    fun setGeometry(geometry: GeometryModel?) {
        this.geometry = geometry
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getTypes(): List<String>? {
        return types
    }

    fun setTypes(types: List<String>) {
        this.types = types
    }

    fun getVicinity(): String? {
        return vicinity
    }

    fun setVicinity(vicinity: String?) {
        this.vicinity = vicinity
    }
}