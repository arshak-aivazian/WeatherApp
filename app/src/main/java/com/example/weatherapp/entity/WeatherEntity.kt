package com.example.weatherapp.entity

import java.io.Serializable

data class WeatherEntity(
    val cityName: String,
    val temp: Double,
    val pressure: Double,
    val windSpeed: Double
) : Serializable