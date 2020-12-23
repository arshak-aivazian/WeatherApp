package com.example.weatherapp.feature.search.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.weatherapp.R
import com.example.weatherapp.feature.search.presentation.SearchWeatherPresenter
import com.example.weatherapp.feature.search.presentation.SearchWeatherView
import com.example.weatherapp.ui.WeeklyWeatherDetailFragment
import kotlinx.android.synthetic.main.fragment_search_weather.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class SearchWeatherFragment : MvpAppCompatFragment(R.layout.fragment_search_weather), SearchWeatherView {

    companion object {
        @JvmStatic
        fun newInstance() = SearchWeatherFragment()
    }

    private val presenter: SearchWeatherPresenter by moxyPresenter {
        SearchWeatherPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnOpenAddCityScreen.setOnClickListener {
            presenter.onWeatherDetailClick(
                etCityName.text.toString(),
                etCountryName.text.toString(),
                etLatitude.text.toString(),
                etLongitude.text.toString()
            )
        }

        rgDayCount.setOnCheckedChangeListener { radioGroup, i ->
            val count = when (i) {
                R.id.rbMonth -> 30
                else -> 5
            }

            presenter.setWeatherDayCount(count)
        }
    }

    override fun showCityNameError() {
        showErrorToast("Город")
    }

    override fun showCoordsError() {
        showErrorToast("Широта и Долгота")
    }

    override fun showCountryNameError() {
        showErrorToast("Страна")
    }

    override fun openWeatherDetail(cityName: String, countryName: String) {
    //переделать после того как будет продумана работа с апи
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeeklyWeatherDetailFragment.newInstance())
            .addToBackStack("SearchWeatherFragment")
            .commit()
    }

    override fun openWeatherDetail(lat: Double, log: Double) {
    //переделать после того как будет продумана работа с апи
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeeklyWeatherDetailFragment.newInstance())
            .addToBackStack("SearchWeatherFragment")
            .commit()
    }

    private fun showErrorToast(name: String) {
        Toast.makeText(requireContext(), "Заполните корректно значения Город и Страна либо Широта и Долгота. Ошибка в поле: $name", Toast.LENGTH_LONG).show()
    }

}