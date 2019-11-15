package com.example.mpoletsky.myapplication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class WeatherHistoryAdapter extends RecyclerView.Adapter<WeatherHistoryAdapter.ViewHolder> {

    private List<WeatherHistory> dataSource;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView temperature;

        public TextView wind;

        public TextView humidity;

        public TextView pressure;

        public TextView history_date;

        public ViewHolder(View v) {
            super(v);
            temperature = v.findViewById(R.id.temperatuere_view);
            wind = v.findViewById(R.id.wind_view);
            humidity = v.findViewById(R.id.humidity_view);
            pressure = v.findViewById(R.id.pressure_view);
            history_date = v.findViewById(R.id.history_date);
        }
    }

    public WeatherHistoryAdapter(List<WeatherHistory> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public WeatherHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.d("WeatherHistoryAdapter", "onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherHistory item = dataSource.get(position);
        holder.temperature.setText(item.getTemperature());
        holder.wind.setText(item.getWind());
        holder.humidity.setText(item.getHumidity());
        holder.pressure.setText(item.getPressure());
        holder.history_date.setText(item.getDate());

        Log.d("WeatherHistoryAdapter", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
