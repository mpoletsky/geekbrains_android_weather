package com.example.mpoletsky.myapplication;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class DataSourceBuilder {

    private List<WeatherHistory> dataSource;

    private Resources resources;

    public DataSourceBuilder(Resources resources) {
        dataSource = new ArrayList<>(6);
        this.resources = resources;
    }

    public List<WeatherHistory> build() {
        String[] cities = resources.getStringArray(R.array.cities);
        String[] temperature01 = resources.getStringArray(R.array.temperature_01);
        String[] wind01 = resources.getStringArray(R.array.wind_01);
        String[] humidity01 = resources.getStringArray(R.array.humidity_01);
        String[] pressure01 = resources.getStringArray(R.array.pressure_01);
        String[] temperature02 = resources.getStringArray(R.array.temperature_02);
        String[] wind02 = resources.getStringArray(R.array.wind_02);
        String[] humidity02 = resources.getStringArray(R.array.humidity_02);
        String[] pressure02 = resources.getStringArray(R.array.pressure_02);
        String[] temperature03 = resources.getStringArray(R.array.temperature_03);
        String[] wind03 = resources.getStringArray(R.array.wind_03);
        String[] humidity03 = resources.getStringArray(R.array.humidity_03);
        String[] pressure03 = resources.getStringArray(R.array.pressure_03);

        for (int i = 0; i < cities.length; i++) {
            dataSource.add(new WeatherHistory(cities[i], "01", temperature01[i], wind01[i], humidity01[i], pressure01[i]));
            dataSource.add(new WeatherHistory(cities[i], "02", temperature02[i], wind02[i], humidity02[i], pressure02[i]));
            dataSource.add(new WeatherHistory(cities[i], "03", temperature03[i], wind03[i], humidity03[i], pressure03[i]));
        }
        return dataSource;
    }
}
