package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ImageView;

public class WeatherActivity extends AppCompatActivity {



    @NonNull
    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ForecastFragment forecastFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.container, forecastFragment).commit();
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