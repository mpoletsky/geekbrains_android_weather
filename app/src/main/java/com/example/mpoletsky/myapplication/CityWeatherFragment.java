package com.example.mpoletsky.myapplication;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CityWeatherFragment extends Fragment {

    public static CityWeatherFragment create(int index) {
        CityWeatherFragment f = new CityWeatherFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    public int getIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_city_weather, container, false);
        TextView cityNameView = (TextView) layout.findViewById(R.id.city_name_view);
        TextView temperatureView = (TextView) layout.findViewById(R.id.temperatuere_view);
        TextView windView = (TextView) layout.findViewById(R.id.wind_view);
        TextView humidityView = (TextView) layout.findViewById(R.id.humidity_view);
        TextView pressureView = (TextView) layout.findViewById(R.id.pressure_view);
        TypedArray cities = getResources().obtainTypedArray(R.array.cities);
        TypedArray temperature = getResources().obtainTypedArray(R.array.temperature);
        TypedArray wind = getResources().obtainTypedArray(R.array.wind);
        TypedArray humidity = getResources().obtainTypedArray(R.array.humidity);
        TypedArray pressure = getResources().obtainTypedArray(R.array.pressure);
        cityNameView.setText(cities.getText(getIndex()).toString());
        temperatureView.setText(temperature.getText(getIndex()).toString());
        windView.setText(wind.getText(getIndex()).toString());
        humidityView.setText(humidity.getText(getIndex()).toString());
        pressureView.setText(pressure.getText(getIndex()).toString());
        return layout;
    }

}
