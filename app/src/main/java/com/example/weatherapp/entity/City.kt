package com.example.weatherapp.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class City (
    val cityName: String,
    val countryName: String
) : Parcelable