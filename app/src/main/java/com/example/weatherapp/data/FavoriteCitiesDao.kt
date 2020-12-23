package com.example.weatherapp.data

import com.example.weatherapp.entity.City

interface FavoriteCitiesDao {
    fun getAll(): List<City>

    fun add(city: City)

    fun delete(city: City)
}