package com.example.weatherapp

fun List<WeatherEntity>.sortWeather(): List<WeatherEntity> {
    return this.sortedBy { it.cityName }
}