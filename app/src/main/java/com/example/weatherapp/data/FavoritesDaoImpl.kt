package com.example.weatherapp.data

import android.content.SharedPreferences
import com.example.weatherapp.entity.City
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class FavoritesDaoImpl(
    private val sharedPreferences: SharedPreferences
) : FavoriteCitiesDao {

    private var cities: List<City>
        get() = sharedPreferences.getString(FAVORITES_DAO_KEY, null)?.let {
            try {
                Json.decodeFromString<List<City>>(it)
            } catch (t: Throwable) {
                emptyList()
            }
        } ?: emptyList()
        set(value) {
            sharedPreferences.edit().putString(
                FAVORITES_DAO_KEY,
                Json.encodeToString(value)
            ).apply()
        }


    override fun add(city: City) {
        cities = cities + city
    }

    override fun delete(city: City) {
        cities = cities.filter { it != city }
    }

    override fun getAll(): List<City> = cities


    companion object {

        private const val FAVORITES_DAO_KEY = "FAVORITES_DAO_KEY"
    }
}