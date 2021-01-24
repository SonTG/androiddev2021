package com.example.reader;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class Menu extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    public void selectIndex(int newIndex) {
        mViewPager.setCurrentItem(newIndex);
    }

    @Override
    public void onBackPressed() {
        int currentPosition = mViewPager.getCurrentItem();
        if (currentPosition != 0) {
            mViewPager.setCurrentItem(0);
        } else {
            super.onBackPressed();
        }
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //call tabLayout and ViewPage
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_page);

        //Connect adapter
        ViewPagerAdapter vIewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(vIewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.reader_main_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //onclick actionbar
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_search:
                search();
                return true;
            case R.id.menu_settings:
                setting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setting() {
        Intent intent = new Intent(Menu.this, btn_settings.class);
        startActivity(intent);
    }

    private void search() {
        Toast.makeText(this, "You click search", Toast.LENGTH_SHORT).show();
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                default:
                    return new Following();
                case 1:
                    return new Discover();
                case 2:
                    return new likes();
                case 3:
                    return new saved();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position) {
                case 0:
                    return title = "Following";
                case 1:
                    return title = "Discover";
                case 2:
                    return title = "Likes";
                case 3:
                    return title = "Saved";

            }
            return title;
        }
    }
}