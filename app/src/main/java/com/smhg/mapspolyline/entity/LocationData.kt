package com.smhg.mapspolyline.entity

import com.google.gson.annotations.SerializedName
import com.smhg.mapspolyline.network.response.ReserveLocationResponse

data class LocationData(
    val address: Address = Address(),
    val coordinate: Coordinate = Coordinate(),
    val name: String = ""
){
    data class Address(
        val city: String = "",
        val country: String = "",
        val distric: String = ""
    )

    data class Coordinate(
        val latitude: Double = 0.0,
        val longitude: Double = 0.0
    )
}