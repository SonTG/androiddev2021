package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    ForecastFragment forecastFragment;
//
//    @NonNull
//    @Override
//    public FragmentManager getSupportFragmentManager() {
//        return super.getSupportFragmentManager();
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
         forecastFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.frame_layout, forecastFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getClass().getName(), "Weather Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getClass().getName(), "Weather Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getClass().getName(), "Weather Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getClass().getName(), "Weather Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getName(), "Weather Activity onDestroy");
    }

}