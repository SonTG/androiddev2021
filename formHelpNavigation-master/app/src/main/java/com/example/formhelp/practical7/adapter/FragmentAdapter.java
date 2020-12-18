package com.example.formhelp.practical7.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.formhelp.practical6.fragment.FragmentForecast1;
import com.example.formhelp.practical6.fragment.FragmentWeather1;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment_switch;
        if (position == 0) {
            fragment_switch = new FragmentWeather1();
        } else
            fragment_switch = new FragmentForecast1();
        return fragment_switch;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Weather";
        }else
            return "Forecast";
    }
}
