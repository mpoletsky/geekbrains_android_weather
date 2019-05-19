package com.example.mpoletsky.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = this.findViewById(R.id.city_name_edit);
        city.setText("Омск");
    }

    public void onGetWeatherButtonClick(View view) {
        CheckBox showTemperature = this.findViewById(R.id.show_temperature_checkbox);
        CheckBox showWind = this.findViewById(R.id.show_wind_checkbox);
        CheckBox showHumidity = this.findViewById(R.id.show_humidity_checkbox);
        CheckBox showPressure = this.findViewById(R.id.show_pressure_checkbox);
        Intent intent = new Intent(this, CityWeatherActivity.class);
        intent.putExtra("cityName", city.getText().toString());
        intent.putExtra("showTemperature", showTemperature.isChecked());
        intent.putExtra("showWind", showWind.isChecked());
        intent.putExtra("showHumidity", showHumidity.isChecked());
        intent.putExtra("showPressure", showPressure.isChecked());
        startActivity(intent);
    }
}
