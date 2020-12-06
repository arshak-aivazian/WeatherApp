package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.entity.WeatherEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToDetails.setOnClickListener {
            val intent = Intent(this@MainActivity, WeatherDetailActivity::class.java)

            val weather = WeatherEntity(
                cityName = "London",
                temp = 10.5,
                pressure = 120.12,
                windSpeed = 13.1
            )

            intent.putExtra("WEATHER", weather)

            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return

        val weatherEntity = data.getSerializableExtra("WEATHER") as WeatherEntity

        tvCityName.text = "Город изменен: ${weatherEntity.cityName}"
    }
}
