package Labwork2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.weather.ForecastFragment;
import vn.edu.usth.weather.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
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