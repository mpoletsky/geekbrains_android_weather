package com.example.mpoletsky.myapplication;

import java.io.Serializable;

public class Parcel implements Serializable {

    private int index;

    private String cityName;

    private String temperature;

    private String wind;

    private String humidity;

    private String pressure;

    public String getCityName() {
        return cityName;
    }

    public int getIndex() {
        return index;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind() {
        return wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public Parcel(int index, String cityName, String temperature, String wind, String humidity, String  pressure) {
        this.index = index;
        this.cityName = cityName;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
    }
}