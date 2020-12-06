package com.example.weatherapp.entity

fun List<WeatherEntity>.sortWeather(): List<WeatherEntity> {
    return this.sortedBy { it.cityName }
}