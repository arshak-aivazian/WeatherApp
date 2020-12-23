package com.example.weatherapp.feature.add_favorite.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.weatherapp.R
import com.example.weatherapp.data.FavoritesDaoImpl
import com.example.weatherapp.feature.add_favorite.presentation.AddFavoritePresenter
import com.example.weatherapp.feature.add_favorite.presentation.AddFavoriteView
import com.example.weatherapp.feature.favorite.ui.FavoriteCitiesFragment
import kotlinx.android.synthetic.main.fragment_add_favorite.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class AddFavoriteFragment : MvpAppCompatFragment(R.layout.fragment_add_favorite), AddFavoriteView {

    companion object {
        @JvmStatic
        fun newInstance() = AddFavoriteFragment()
    }

    private val presenter: AddFavoritePresenter by moxyPresenter {
        AddFavoritePresenter(
            favoritesDao = FavoritesDaoImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddFavoriteCity.setOnClickListener {
            presenter.onSaveNewFavoriteClicked(etCityName.text.toString(), etCountryName.text.toString())
        }
    }

    override fun showCityNameError() {
        showErrorToast("Город")
    }

    override fun showCountryNameError() {
        showErrorToast("Страна")
    }

    override fun saveFavorite() {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, FavoriteCitiesFragment.newInstance())
            .commit()
    }

    private fun showErrorToast(name: String) {
        Toast.makeText(requireContext(), "Ошибка в поле: $name", Toast.LENGTH_LONG).show()
    }
}