package com.example.weatherapp.feature.add_favorite.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

interface AddFavoriteView: MvpView {
    @Skip
    fun showCityNameError()

    @Skip
    fun showCountryNameError()

    @OneExecution
    fun saveFavorite()
}