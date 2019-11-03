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

    }
}
