package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.weatherapp.R
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.synthetic.main.fragment_city_weather.*

class CityWeatherFragment : Fragment(R.layout.fragment_city_weather) {

    companion object {

        private const val WEATHER = "WEATHER"

        @JvmStatic
        fun newInstance(weather: WeatherEntity) =
            CityWeatherFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER, weather)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val weather = it.getParcelable<WeatherEntity>(WEATHER)

            tvCityName.text = "Город: ${weather?.cityName}"
            tvTemp.text = "Температура: ${weather?.temp}°C"
        }

        btnGoToWeatherDetail.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeeklyWeatherDetailFragment.newInstance())
                .addToBackStack("WeeklyWeatherDetailFragment")
                .commit()
        }
    }
}
