package com.example.weatherapp.feature.search.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

interface SearchWeatherView : MvpView {
    @Skip
    fun showCityNameError()

    @Skip
    fun showCountryNameError()

    @Skip
    fun showCoordsError()

    @OneExecution
    fun openWeatherDetail(cityName: String, countryName: String)

    @OneExecution
    fun openWeatherDetail(lat: Double, log: Double)
}