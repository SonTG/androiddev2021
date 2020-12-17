package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ForecastFragment extends Fragment {
    WeatherAdapter adapter;
    ArrayList<Weather> weathers;

    String Date[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    String Weather[] = {
            "Partly Cloudy\n24C - 31C",
            "Showers\n24C - 30C",
            "Rain\n22C - 23C",
            "Scattered Showers\n22C - 27C",
            "Mostly Cloudy\n22C - 30C",
            "Partly Cloudy\n24C - 31C",
            "Thunderstorms\n25C - 28C"
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View forecastFragment = inflater.inflate(R.layout.forecastfragment, container, false);

        TextView date = (TextView) forecastFragment.findViewById(R.id.date);
        TextView weather = (TextView) forecastFragment.findViewById(R.id.weather);
        RecyclerView recyclerView = (RecyclerView) forecastFragment.findViewById(R.id.recycler_view);

        weathers = new ArrayList<Weather>();

        for (int i = 0; i < Date.length; i++) {
            weathers.add(new Weather(Date[i], Weather[i]));
        }

        adapter = new WeatherAdapter(weathers, this.getContext());

        recyclerView.setAdapter(adapter);
        Log.e(getClass().getName(),"on view created");
        return forecastFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getClass().getName(),"on Activity created");
    }
}
