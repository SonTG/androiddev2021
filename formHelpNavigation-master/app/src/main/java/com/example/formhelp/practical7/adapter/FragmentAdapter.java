package com.example.formhelp.practical7.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.formhelp.practical6.fragment.FragmentForecast1;
import com.example.formhelp.practical6.fragment.FragmentWeather1;
import com.example.formhelp.practical7.fragment.FragmentWeatherAndForecast;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new FragmentWeatherAndForecast();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Fragment Weather ForeCast";
    }
}
