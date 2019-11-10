package com.example.mpoletsky.myapplication;

public class WeatherHistory {

    String city;

    String date;

    String temperature;

    String wind;

    String humidity;

    String pressure;

    public WeatherHistory(String city, String date, String temperature, String wind, String humidity, String pressure) {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind() { return wind; }

    public String getHumidity() { return humidity; }

    public String getPressure() { return pressure; }

}
