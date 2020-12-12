package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.weatherapp.R
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.synthetic.main.fragment_favorite_city.*

class FavoriteCityFragment : Fragment(R.layout.fragment_favorite_city) {

    companion object {
        @JvmStatic
        fun newInstance() = FavoriteCityFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoToCityWeather.setOnClickListener {
            val weather = WeatherEntity(cityName = "Москва", temp = 15.3, pressure = 123.2, windSpeed = 5.0)

            requireFragmentManager().beginTransaction()
                .replace(R.id.container, CityWeatherFragment.newInstance(weather))
                .addToBackStack("CityWeatherFragment")
                .commit()
        }
    }
}
