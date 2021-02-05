package com.example.formhelp.practical6.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formhelp.R;
import com.example.formhelp.practical5.adapter.AdapterStatus;
import com.example.formhelp.practical5.status.Status;

import java.util.ArrayList;

public class FragmentWeather1 extends Fragment {
    private RecyclerView rclStatusWeather;
    private ArrayList<Status>statuses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_1,container,false);
        statuses = new ArrayList<>();
        statuses.add(new Status("Partly Cloudy",R.drawable.cloudyo,"24C","31C","Mon"));
        statuses.add(new Status("Showers",R.drawable.raino,"24C","30C","Tue"));
        statuses.add(new Status("Rain",R.drawable.raino,"22C","30C","Wed"));
        statuses.add(new Status("Scatted Showers",R.drawable.cloudyo,"22C","27C","Thu"));
        statuses.add(new Status("Mostly Cloudy",R.drawable.cloudyo,"22C","30C","Fri"));
        statuses.add(new Status("Partly Cloudy",R.drawable.cloudyo,"24C","31C","Sat"));
        statuses.add(new Status("ThunderStorms",R.drawable.raino,"25C","28C","Sun"));
        statuses.add(new Status("Scatted ThunderStorms",R.drawable.ic_cloud,"24C","27C","Mon"));
        statuses.add(new Status("Showers",R.drawable.raino,"24C","26C","Tue"));
        statuses.add(new Status("Scatted ThunderStorms",R.drawable.ic_cloud,"23C","27C","Wed"));
        rclStatusWeather = view.findViewById(R.id.rcl_weather_status);
        AdapterStatus adapterStatus = new AdapterStatus(statuses,view.getContext());
        rclStatusWeather.setAdapter(adapterStatus);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
