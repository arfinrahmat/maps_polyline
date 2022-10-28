package com.smhg.mapspolyline.network

import com.smhg.mapspolyline.entity.LocationData
import com.smhg.mapspolyline.network.response.ReserveLocationResponse

object ResponseMapper {
    fun mapReserveLocationResponseToLocation(reserveLocationResponse: ReserveLocationResponse.ReserveLocationResponse?): LocationData {
        val address = reserveLocationResponse?.data?.address.run {
            LocationData.Address(
                city = this?.city.orEmpty(),
                country = this?.country.orEmpty(),
                distric = this?.distric.orEmpty()
            )
        }
        val coordinate = reserveLocationResponse?.data?.coordinate.run {
            LocationData.Coordinate(
                latitude = this?.latitude ?: 0.0,
                longitude = this?.longitude ?: 0.0
            )
        }
        val name = reserveLocationResponse?.data?.name.orEmpty()
        return LocationData(
            address = address,
            coordinate = coordinate,
            name = name
        )
    }
}