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

    public List<WeatherHistory> build(int index) {
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
        String[] history_dates = resources.getStringArray(R.array.history_dates);

        dataSource.add(new WeatherHistory(cities[index], history_dates[0], temperature01[index], wind01[index], humidity01[index], pressure01[index]));
        dataSource.add(new WeatherHistory(cities[index], history_dates[1], temperature02[index], wind02[index], humidity02[index], pressure02[index]));
        dataSource.add(new WeatherHistory(cities[index], history_dates[2], temperature03[index], wind03[index], humidity03[index], pressure03[index]));

        return dataSource;
    }
}
