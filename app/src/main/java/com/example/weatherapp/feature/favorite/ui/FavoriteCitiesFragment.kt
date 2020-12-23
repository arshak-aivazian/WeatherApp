package com.example.weatherapp.feature.favorite.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.data.FavoritesDaoImpl
import com.example.weatherapp.entity.City
import com.example.weatherapp.entity.WeatherEntity
import com.example.weatherapp.feature.add_favorite.ui.AddFavoriteFragment
import com.example.weatherapp.feature.favorite.presentation.FavoriteCitiesPresenter
import com.example.weatherapp.feature.favorite.presentation.FavoriteCitiesView
import com.example.weatherapp.ui.CityWeatherFragment
import kotlinx.android.synthetic.main.fragment_favorite_cities.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FavoriteCitiesFragment : MvpAppCompatFragment(R.layout.fragment_favorite_cities), FavoriteCitiesView {

    companion object {

        @JvmStatic
        fun newInstance() = FavoriteCitiesFragment()
    }

    private val presenter: FavoriteCitiesPresenter by moxyPresenter {
        FavoriteCitiesPresenter(
            favoritesDao = FavoritesDaoImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    private var citiesAdapter: FavoriteCitiesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvCityList) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FavoriteCitiesAdapter(
                onCityClicked = { presenter.onCityClicked(it) },
                onDeleteClicked = { presenter.onDeleteClicked(it) }
            ).also {
                citiesAdapter = it
            }
        }

        btnOpenAddCityScreen.setOnClickListener {
            presenter.onOpenAddFavoriteScreenClicked()
        }
    }

    override fun onDestroyView() {
        citiesAdapter = null
        super.onDestroyView()
    }

    override fun setCities(cities: List<City>) {
        citiesAdapter?.submitList(cities)
    }

    override fun openWeatherDetail(city: City) {
        //доделать
        val weather = WeatherEntity(city.cityName, 12.0, 123.1, 123.1)

        requireFragmentManager().beginTransaction()
            .replace(R.id.container, CityWeatherFragment.newInstance(weather))
            .addToBackStack("CityWeatherFragment")
            .commit()
    }

    override fun openAddCityScreen() {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, AddFavoriteFragment.newInstance())
            .addToBackStack("CityWeatherFragment")
            .commit()
    }
}
