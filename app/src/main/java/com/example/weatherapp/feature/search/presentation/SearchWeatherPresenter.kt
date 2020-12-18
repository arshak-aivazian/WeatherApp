package com.example.weatherapp.feature.search.presentation

import moxy.MvpPresenter

class SearchWeatherPresenter : MvpPresenter<SearchWeatherView>() {

    private var weatherDayCount: Int = 5

    fun onWeatherDetailClick(cityName: String, countryName: String, lat: String, long: String) {
        when {
            cityName.isNotEmpty() && countryName.isNotEmpty() -> viewState.openWeatherDetail(cityName, countryName)
            isCoordsCorrect(lat, long) -> viewState.openWeatherDetail(lat.toDouble(), long.toDouble())
            !isCoordsCorrect(lat, long) && cityName.isEmpty() -> viewState.showCityNameError()
            !isCoordsCorrect(lat, long) && countryName.isEmpty() -> viewState.showCountryNameError()
            cityName.isEmpty() && countryName.isEmpty() && !isCoordsCorrect(lat, long) -> viewState.showCoordsError()
        }
    }

    fun setWeatherDayCount(count: Int) {
        weatherDayCount = count
    }

    private fun isCoordsCorrect(lat: String, long: String): Boolean {
        if (lat.isEmpty() && long.isEmpty()) return false

        return try {
            lat.toDouble() in -90.0..90.0
            long.toDouble() in -180.0..180.0
            true
        } catch (e: Exception) {
            false
        }
    }
}