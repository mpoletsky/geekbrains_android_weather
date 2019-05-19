package com.example.mpoletsky.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CityWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        String text = getIntent().getExtras().getString("cityName");
        TextView city = findViewById(R.id.city_name_view);
        city.setText(text);
        TextView temperature = findViewById(R.id.temperatuere_view);
        ImageView temperature_image = findViewById(R.id.temperature_image_view);
        Boolean showTemperature = getIntent().getExtras().getBoolean("showTemperature");
        if (!showTemperature) {
            temperature.setVisibility(View.INVISIBLE);
            temperature_image.setVisibility(View.INVISIBLE);
        }
        TextView wind = findViewById(R.id.wind_view);
        ImageView wind_image = findViewById(R.id.wind_image_view);
        Boolean showWind = getIntent().getExtras().getBoolean("showWind");
        if (!showWind) {
            wind.setVisibility(View.INVISIBLE);
            wind_image.setVisibility(View.INVISIBLE);
        }
        TextView humidity = findViewById(R.id.humidity_view);
        ImageView humidity_image = findViewById(R.id.humidity_image_view);
        Boolean showHumidity = getIntent().getExtras().getBoolean("showHumidity");
        if (!showHumidity) {
            humidity.setVisibility(View.INVISIBLE);
            humidity_image.setVisibility(View.INVISIBLE);
        }
        TextView pressure = findViewById(R.id.pressure_view);
        ImageView pressure_image = findViewById(R.id.pressure_image_view);
        Boolean showPressure = getIntent().getExtras().getBoolean("showPressure");
        if (!showPressure) {
            pressure.setVisibility(View.INVISIBLE);
            pressure_image.setVisibility(View.INVISIBLE);
        }
    }
}
