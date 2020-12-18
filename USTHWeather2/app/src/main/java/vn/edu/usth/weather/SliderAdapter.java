package vn.edu.usth.weather;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class SliderAdapter extends FragmentStatePagerAdapter {
    public SliderAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public SliderAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WeatherAndForecastFragment();

            case 1:
                return new WeatherAndForecastFragment();

            case 2:
                return new WeatherAndForecastFragment();

            default:
                return new WeatherAndForecastFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "TAB 1";
        } else if (position == 1) {
            return "TAB 2";
        } else
            return "TAB 3";
    }
}
