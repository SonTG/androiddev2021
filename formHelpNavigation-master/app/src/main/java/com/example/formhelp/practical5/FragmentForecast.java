package com.example.formhelp.practical5;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formhelp.R;
import com.example.formhelp.practical5.adapter.AdapterStatus;
import com.example.formhelp.practical5.status.Status;

import java.util.ArrayList;

public class FragmentForecast  extends Fragment implements View.OnClickListener {
    private ArrayList<Status>statuses;
    private ImageView imgReverse;
    private ImageView imgSetting;
    private RecyclerView rclStatus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forcast_list,container,false);
        Log.i(getClass().getName(),"onCreateView created");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initArrayList();
        imgSetting = getActivity().findViewById(R.id.img_setting);
        imgReverse = getActivity().findViewById(R.id.img_reverse);
        rclStatus = getActivity().findViewById(R.id.rcl_status);
        imgReverse.setOnClickListener(this);
        imgSetting.setOnClickListener(this);
        rclStatus.setAdapter(new AdapterStatus(statuses,getContext()));
        Log.i(getClass().getName(),"onActivity created");
    }

    private void initArrayList() {
        statuses= new ArrayList<>();
        statuses.add(new Status(getContext().getResources().getString(
                R.string.partly_cloudy),R.drawable.cloudyo,"24C","31C","Mon"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.showers),R.drawable.raino,"24C","30C","Tue"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.rain),R.drawable.raino,"22C","30C","Wed"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.scattered_shower),R.drawable.cloudyo,"22C","27C","Thu"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.mostly_cloudy),R.drawable.cloudyo,"22C","30C","Fri"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.partly_cloudy),R.drawable.cloudyo,"24C","31C","Sat"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.thunderstorm),R.drawable.raino,"25C","28C","Sun"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.scattered_thunder_storm),R.drawable.ic_cloud,"24C","27C","Mon"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.showers),R.drawable.raino,"24C","26C","Tue"));
        statuses.add(new Status(getContext().getResources().getString(
                R.string.scattered_thunder_storm),R.drawable.ic_cloud,"23C","27C","Wed"));
    }

    @Override
    public void onClick(View v) {

    }
}
