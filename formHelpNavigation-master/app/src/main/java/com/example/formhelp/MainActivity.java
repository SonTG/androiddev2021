package com.example.formhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.formhelp.practical1.FragmentHelloWorld;
import com.example.formhelp.practical11.FragmentListenYourIdol;
import com.example.formhelp.practical2.fragment.FragmentLogActivity;
import com.example.formhelp.practical3.FragmentBackground;
import com.example.formhelp.practical4.FragmentWeather;
import com.example.formhelp.practical5.FragmentForecast;
import com.example.formhelp.practical6.fragment.FragmentDirection;
import com.example.formhelp.practical7.fragment.FragmentPager;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentWeather fragmentWeather = new FragmentWeather();
    private FragmentHelloWorld fragmentHelloWorld = new FragmentHelloWorld();
    private FragmentLogActivity fragmentLogActivity = new FragmentLogActivity();
    private FragmentBackground fragmentBackground = new FragmentBackground();
    private FragmentForecast fragmentForecast = new FragmentForecast();
    ImageView imageViewBar;
    DrawerLayout drawerLayout;
    NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        imageViewBar = findViewById(R.id.img_bar);
        nav = findViewById(R.id.navigationView);
        nav.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawable);
        imageViewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(nav);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.practical_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,fragmentHelloWorld).commit();
                break;
            case R.id.practical_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,fragmentLogActivity).commit();
                break;
            case R.id.practical_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,fragmentBackground).commit();
                break;
            case R.id.practical_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,fragmentWeather).commit();
                break;
            case R.id.practical_5:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,fragmentForecast).commit();
                break;
            case R.id.practical_6:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,new FragmentDirection()).commit();
                break;
            case R.id.practical_7:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,new FragmentPager()).commit();
                break;
            case R.id.practical_11:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_,new FragmentListenYourIdol()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
