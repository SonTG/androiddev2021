package com.example.usthwheather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {
    private final static String TAG = "WeatherActivity";
    //    private AppBarConfiguration appBarConfiguration;
    private MediaPlayer player;

    public WeatherActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Log.i(TAG, "on create...");

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        player = MediaPlayer.create(this, R.raw.song);
        player.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on start...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on resume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on pause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
        player.release();
        player = null;
        Log.i(TAG, "on stop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "on destroy...");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[]{"Hanoi", "Paris", "Toulouse"};

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }

        @Override
        public Fragment getItem(int page) {
// returns an instance of Fragment corresponding to the specified page
            switch (page) {
                case 0:
                    return new WeatherAndForecast();
                case 1:
                    return new WeatherAndForecast();
                case 2:
                    return new WeatherAndForecast();
            }
            return new Fragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
            return titles[page];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                new refresh().execute();
                return true;
            case R.id.action_settings:
                Log.d(TAG, "onOptionsItemSelected: click");
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class refresh extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdate(Void... voids) {
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(getApplicationContext(),
                    "some sample json here",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }

//    // initialize URL
//    URL url = new URL("http://ict.usth.edu.vn/wp-content/" +
//            "uploads/usth/usthlogo.png");
//    // Make a request to server
//    HttpURLConnection connection =
//            (HttpURLConnection) url.openConnection();
//connection.setRequestMethod("GET");
//connection.setDoInput(true);
//// allow reading response code and response dataconnection.
//connection.connect();
//    // Receive response
//    int response = connection.getResponseCode();
//Log.i("USTHWeather","The response is: "+response);
//    InputStream is = connection.getInputStream();
//    // Process image response
//    Bitmap bitmap = BitmapFactory.decodeStream(is);
//    ImageView logo = (ImageView) findViewById(R.id.logo);
//logo.setImageBitmap(bitmap);
//connection.disconnect();
}