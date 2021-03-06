package com.example.weatherapp.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class WeatherEntity(
    val cityName: String,
    val temp: Double,
    val pressure: Double,
    val windSpeed: Double
) : Parcelable