package com.example.weatherapp.feature.favorite.presentation

import com.example.weatherapp.entity.City
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface FavoriteCitiesView: MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCities(cities: List<City>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDetail(city: City)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openAddCityScreen()

}