package com.example.weatherapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.synthetic.main.activity_weather_detail.*

class WeatherDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        val weather = intent.extras?.getSerializable("WEATHER") as WeatherEntity

        tvCityName.text = "Город: ${weather.cityName}"
        tvTemp.text = "Температура: ${weather.temp}°C"

        btnReturn.setOnClickListener {
            val intent = Intent()

            val weather = WeatherEntity(
                cityName = "Bally",
                temp = 30.12,
                pressure = 15.12,
                windSpeed = 5.1
            )

            intent.putExtra("WEATHER", weather)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}
