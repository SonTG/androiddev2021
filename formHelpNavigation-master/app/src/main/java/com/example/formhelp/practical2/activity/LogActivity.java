package com.example.formhelp.practical2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.formhelp.R;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getClass().getName(),"LogActivity created");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getClass().getName(),"LogActivity paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getClass().getName(),"LogActivity resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getName(),"LogActivity destroyed");
    }
}