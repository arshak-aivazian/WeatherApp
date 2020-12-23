package com.example.weatherapp.feature.favorite.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.entity.City
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.favorite_city_item.*

class FavoriteCitiesAdapter(
    private val onCityClicked: (City) -> Unit,
    private val onDeleteClicked: (City) -> Unit
) : ListAdapter<City, FavoriteCitiesAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean =
            oldItem.cityName == newItem.cityName

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean =
            oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.favorite_city_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = getItem(position)
        holder.tvCity.text = "${city.cityName}, ${city.countryName}"

        holder.containerView.setOnClickListener {
            onCityClicked(city)
        }

        holder.btnRemove.setOnClickListener {
            onDeleteClicked(city)
        }
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer
}