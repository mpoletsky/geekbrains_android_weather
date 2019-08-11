package com.example.mpoletsky.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CitiesFragment extends Fragment {

    private ListView listView;
    private TextView emptyTextView;

    boolean isLandscape;
    int currentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("currentCity", 0);
        }

        if (isLandscape) {
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCityWeather();
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("CurrentCity", currentPosition);
        super.onSaveInstanceState(outState);
    }

    private void initViews(View view) {
        listView = view.findViewById(R.id.cities_list_view);
        emptyTextView = view.findViewById(R.id.cities_list_empty_view);
    }

    private void initList() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cities, android.R.layout.simple_list_item_activated_1);
        listView.setAdapter(adapter);

        listView.setEmptyView(emptyTextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                currentPosition = position;
                showCityWeather();
            }
        });
    }

    private void showCityWeather() {
        if (isLandscape) {
            listView.setItemChecked(currentPosition, true);
            CityWeatherFragment detail = (CityWeatherFragment) getFragmentManager().findFragmentById(R.id.city_weather);
            if (detail == null || detail.getIndex() != currentPosition) {
                detail = CityWeatherFragment.create(currentPosition);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.city_weather, detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CityWeatherActivity.class);
            intent.putExtra("index", currentPosition);
            startActivity(intent);
        }
    }
}
