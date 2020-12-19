package vn.edu.usth.weather;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ForecastFragment extends Fragment {
    WeatherAdapter adapter;
    ArrayList<Weather> weathers;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View forecastFragment = inflater.inflate(R.layout.forecastfragment, container, false);

        RecyclerView recyclerView = forecastFragment.findViewById(R.id.recycler_view);

        weathers = new ArrayList<Weather>();
        String Date[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        String Mon = getContext().getResources().getString(R.string.Mon);
        String Tue = getContext().getResources().getString(R.string.Tue);
        String Wed = getContext().getResources().getString(R.string.Wed);
        String Thu = getContext().getResources().getString(R.string.Thu);
        String Fri = getContext().getResources().getString(R.string.Fri);
        String Sat = getContext().getResources().getString(R.string.Sat);
        String Sun = getContext().getResources().getString(R.string.Sun);

        String Weather[] = {
            (Mon + "\n24C - 31C"),
            (Tue + "\n24C - 30C"),
            (Wed + "\n22C - 23C"),
            (Thu + "\n22C - 27C"),
            (Fri + "\n22C - 30C"),
            (Sat + "\n24C - 31C"),
            (Sun + "\n25C - 28C")
        };

        int image[] = {
                R.drawable.weather_icon,
                R.drawable.rain_icon,
                R.drawable.rain_icon,
                R.drawable.rain_icon,
                R.drawable.cloud_icon,
                R.drawable.cloud_icon,
                R.drawable.thunder_icon
        };

        for (int i = 0; i < Date.length; i++) {
            weathers.add(new Weather(Date[i], image[i], Weather[i]));
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
