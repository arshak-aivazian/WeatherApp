package com.example.weatherapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val weather1 = WeatherEntity(cityName = "Yerevan", temp = 10.12, pressure = 120.12, windSpeed = 13.1)
    val weather2 = WeatherEntity(cityName = "Abakan", temp = -30.1, pressure = 10.12, windSpeed = 123.1)
    val weather3 = WeatherEntity(cityName = "London", temp = 10.12, pressure = 120.12, windSpeed = 123.1)
    val weather4 = WeatherEntity(cityName = "Bally", temp = 30.12, pressure = 15.12, windSpeed = 5.1)

    val weatherList = listOf<WeatherEntity>(weather1, weather2, weather3, weather4)

    @Test
    fun addition_isCorrect() {
        print(weatherList.sortWeather())
    }
}
