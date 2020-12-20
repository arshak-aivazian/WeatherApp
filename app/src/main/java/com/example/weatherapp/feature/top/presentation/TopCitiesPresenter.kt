package com.example.weatherapp.feature.top.presentation

import com.example.weatherapp.entity.WeatherEntity
import moxy.MvpPresenter

class TopCitiesPresenter : MvpPresenter<TopCitiesView>() {
    private var cities = listOf<WeatherEntity>(
        WeatherEntity("London", -5.0, 123.0, 10.0),
        WeatherEntity("Moscow", -5.0, 123.0, 10.0),
        WeatherEntity("New York", 25.0, 123.0, 10.0),
        WeatherEntity("Los Angeles", 35.0, 123.0, 10.0),
        WeatherEntity("Sidney", 35.0, 123.0, 10.0),
        WeatherEntity("Berlin", 0.0, 123.0, 10.0),
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showCities(cities)
    }

    fun onCityClicked(city: WeatherEntity) {
        viewState.openWeatherDetail(city)
    }

    fun onDeleteClicked(city: WeatherEntity) {
        cities = cities.filter { it.cityName != city.cityName }
        viewState.showCities(cities)
    }
}