package com.example.mpoletsky.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.SQLOutput;

public class CityAdapter extends ArrayAdapter<WeatherHistory> {

    public CityAdapter(Context context) {
        super(context, R.layout.cities_item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cities_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WeatherHistory cityItem = getItem(position);

        holder.textViewCity.setText(cityItem.getCity());
        holder.textViewTemperature.setText(cityItem.getTemperature());
        holder.textViewWind.setText(cityItem.getWind());
        holder.textViewHumidity.setText(cityItem.getHumidity());
        holder.textViewPressure.setText(cityItem.getPressure());

        return convertView;
    }

    static class ViewHolder {
        TextView textViewCity;
        TextView textViewTemperature;
        TextView textViewWind;
        TextView textViewHumidity;
        TextView textViewPressure;

        ViewHolder(View view) {
            textViewCity = view.findViewById(R.id.city_name);
            textViewTemperature = view.findViewById(R.id.temperatuere_view);
            textViewWind = view.findViewById(R.id.wind_view);
            textViewHumidity = view.findViewById(R.id.humidity_view);
            textViewPressure = view.findViewById(R.id.pressure_view);
        }
    }
}
