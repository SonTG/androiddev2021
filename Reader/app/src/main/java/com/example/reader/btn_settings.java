package com.example.reader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class btn_settings extends AppCompatActivity {

    private TabLayout nTabLayout;
    private ViewPager nViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_settings);

        //call tabLayout and ViewPage
        nTabLayout = findViewById(R.id.tab_lay_set);
        nViewPager = findViewById(R.id.view_page_set);

        //Connect adapter
        Adapter adapter = new Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        nViewPager.setAdapter(adapter);
        nTabLayout.setupWithViewPager(nViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.reader_btn_settings_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.btn_done:
                Intent intent = new Intent(btn_settings.this, Menu.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

class Adapter extends FragmentStatePagerAdapter {
    public Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return new setting1();
            case 1:
                return new setting2();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                return title = "Followed Topics";
            case 1:
                return title = "Followed Sites";
        }
        return title;
    }
}