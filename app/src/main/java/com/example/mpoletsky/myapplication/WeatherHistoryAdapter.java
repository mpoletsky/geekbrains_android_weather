package com.example.mpoletsky.myapplication;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class WeatherHistoryAdapter extends RecyclerView.Adapter<WeatherHistoryAdapter.ViewHolder> {

    private String data;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public WeatherHistoryAdapter(String data) {

    }
}
