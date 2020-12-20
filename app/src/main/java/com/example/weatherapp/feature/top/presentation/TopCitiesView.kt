package com.example.weatherapp.feature.top.presentation

import com.example.weatherapp.entity.WeatherEntity
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface TopCitiesView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCities(cities: List<WeatherEntity>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDetail(city: WeatherEntity)

}