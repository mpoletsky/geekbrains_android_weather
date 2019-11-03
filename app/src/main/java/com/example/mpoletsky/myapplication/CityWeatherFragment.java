package com.example.mpoletsky.myapplication;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CityWeatherFragment extends Fragment {

    public static final String PARCEL = "parcel";

    public static CityWeatherFragment create(Parcel parcel) {
        CityWeatherFragment f = new CityWeatherFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }

    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    private String getIndicatorString(String indicator_type, String value) {
        String text = "";
        String unit = "";
        switch (indicator_type) {
            case "temperature":
                text = getResources().getString(R.string.temperature);
                unit = getResources().getString(R.string.temperature_unit);
                break;
            case "wind":
                text = getResources().getString(R.string.wind);
                unit = getResources().getString(R.string.wind_unit);
                break;
            case "humidity":
                text = getResources().getString(R.string.humidity);
                unit = getResources().getString(R.string.humidity_unit);
                break;
            case "pressure":
                text = getResources().getString(R.string.pressure);
                unit = getResources().getString(R.string.pressure_unit);
                break;
        }
        return text + ": " + value + " " + unit;
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
        Parcel parcel = getParcel();
        cityNameView.setText(parcel.getCityName());
        temperatureView.setText(getIndicatorString("temperature", parcel.getTemperature()));
        windView.setText(getIndicatorString("wind", parcel.getWind()));
        humidityView.setText(getIndicatorString("humidity", parcel.getHumidity()));
        pressureView.setText(getIndicatorString("pressure", parcel.getPressure()));

        RecyclerView recyclerView = layout.findViewById(R.id.history_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        WeatherHistoryAdapter adapter = new WeathetHistoryAdapter(data);
        recyclerView.setAdapter(adapter);

        return layout;
    }

}
