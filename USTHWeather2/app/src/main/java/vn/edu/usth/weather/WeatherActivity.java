package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    WeatherAndForecastFragment weatherAndForecastFragment;
    ViewPager viewPager;
    TextView pagination;
    int total = 4, count = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        viewPager = findViewById(R.id.view_pager);
        pagination = findViewById(R.id.pagination);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new SliderAdapter(getSupportFragmentManager()));

        pagination.setText(count + "/" + total);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = 0;
                count = position + 1;
                pagination.setText(count + "/" + total);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.icon_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh: {
                AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        SystemClock.sleep(2000);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        Toast.makeText(WeatherActivity.this, "123", Toast.LENGTH_SHORT).show();
                    }
                };
                task.execute();

                Log.i(getClass().getName(),"Log info refresh");
                return true;
            }
            case R.id.menu_settings: {
                Toast.makeText(this, "Settings Action Button", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, PrefActivity.class));
                return true;
            }
            default: {
                super.onOptionsItemSelected(item);
            }
        }
        return  false;
    }


    //   public void refresh() {
//        final Handler handler = new Handler(Looper.getMainLooper()) {
//            @Override
//            public void handleMessage(Message msg) {
//                // This method is executed in main thread
//                String content = msg.getData().getString("server_response");
//                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        Thread t = new Thread(new Runnable() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void run() {
//                // this method is run in a worker thread
//                try {
//                    // wait for 5 seconds to simulate a long network access
//                    Thread.sleep(5000);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                // Assume that we got our data from server
//                Bundle bundle = new Bundle();
//                bundle.putString("server_response", "some sample json here");
//                // notify main thread
//                Message msg = new Message();
//                msg.setData(bundle);
//                handler.sendMessage(msg);
//            }
//        });
//        t.start();


//    }
}