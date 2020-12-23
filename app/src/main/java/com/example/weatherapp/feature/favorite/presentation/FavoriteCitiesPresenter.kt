package com.example.weatherapp.feature.favorite.presentation

import com.example.weatherapp.data.FavoriteCitiesDao
import com.example.weatherapp.entity.City
import moxy.MvpPresenter

class FavoriteCitiesPresenter(private val favoritesDao: FavoriteCitiesDao) :
    MvpPresenter<FavoriteCitiesView>() {
    private var cities: List<City> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        cities = favoritesDao.getAll()
        viewState.setCities(cities)
    }

    fun onCityClicked(city: City) {
        viewState.openWeatherDetail(city)
    }

    fun onDeleteClicked(city: City) {
        favoritesDao.delete(city)
        cities = favoritesDao.getAll()
        viewState.setCities(cities)
    }

    fun onOpenAddFavoriteScreenClicked() {
        viewState.openAddCityScreen()
    }
}