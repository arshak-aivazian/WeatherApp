package com.example.weatherapp.feature.top.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.entity.WeatherEntity
import com.example.weatherapp.feature.top.presentation.TopCitiesPresenter
import com.example.weatherapp.feature.top.presentation.TopCitiesView
import com.example.weatherapp.ui.CityWeatherFragment
import kotlinx.android.synthetic.main.fragment_top_cities.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class TopCitiesFragment : MvpAppCompatFragment(R.layout.fragment_top_cities), TopCitiesView {

    companion object {
        @JvmStatic
        fun newInstance() = TopCitiesFragment()
    }

    private val presenter: TopCitiesPresenter by moxyPresenter { TopCitiesPresenter() }

    private var citiesAdapter: TopCitiesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvCityList) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = TopCitiesAdapter(
                onCityClicked = { presenter.onCityClicked(it) },
                onDeleteClicked = { presenter.onDeleteClicked(it) }
            ).also {
                citiesAdapter = it
            }
        }
    }

    override fun onDestroyView() {
        citiesAdapter = null
        super.onDestroyView()
    }

    override fun showCities(cities: List<WeatherEntity>) {
        citiesAdapter?.submitList(cities)
    }

    override fun openWeatherDetail(city: WeatherEntity) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, CityWeatherFragment.newInstance(city))
            .addToBackStack("TopCitiesFragment")
            .commit()
    }
}
