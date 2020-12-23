package com.example.weatherapp.feature.add_favorite.presentation

import com.example.weatherapp.data.FavoriteCitiesDao
import com.example.weatherapp.entity.City
import moxy.MvpPresenter

class AddFavoritePresenter(private val favoritesDao: FavoriteCitiesDao) : MvpPresenter<AddFavoriteView>() {

    fun onSaveNewFavoriteClicked(cityName: String, countryName: String) {
        when {
            cityName.isEmpty() -> viewState.showCityNameError()
            countryName.isEmpty() -> viewState.showCountryNameError()
            else -> {
                favoritesDao.add(City(cityName, countryName))
                viewState.saveFavorite()
            }
        }
    }
}