package com.example.weatherapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.synthetic.main.fragment_city_list.*

class CityListFragment : Fragment(R.layout.fragment_city_list) {

    companion object {
        @JvmStatic
        fun newInstance() = CityListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoToDetails.setOnClickListener {

            val weather = WeatherEntity(
                cityName = "London",
                temp = 10.5,
                pressure = 120.12,
                windSpeed = 13.1
            )

            requireFragmentManager().beginTransaction()
                .replace(R.id.container,CityWeatherFragment.newInstance(weather))
                .addToBackStack("CityWeatherFragment")
                .commit()
        }

        btnGoToFavoriteCities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, FavoriteCityFragment.newInstance())
                .addToBackStack("FavoriteCityFragment")
                .commit()
        }
    }
}
