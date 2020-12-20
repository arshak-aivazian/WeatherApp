package com.example.weatherapp.feature.top.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.top_city_item.*

class TopCitiesAdapter(
    private val onCityClicked: (WeatherEntity) -> Unit,
    private val onDeleteClicked: (WeatherEntity) -> Unit
) : ListAdapter<WeatherEntity, TopCitiesAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<WeatherEntity>() {
        override fun areItemsTheSame(oldItem: WeatherEntity, newItem: WeatherEntity): Boolean =
            oldItem.cityName == newItem.cityName

        override fun areContentsTheSame(oldItem: WeatherEntity, newItem: WeatherEntity): Boolean =
            oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_city_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = getItem(position)
        holder.tvCityName.text = city.cityName
        holder.tvTemperature.text = "${city.temp}"

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