package com.example.formhelp.practical6.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.formhelp.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultipleFragmentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_fragment);
    }
    private void downloadImage(){
        try {
            //initial url
            URL url = new URL("https://smallimg.pngkey.com/png/small/185-1858620_neko-atsume-marshmallow-plush.png");
            //Make request to server
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            //allow read responding code and responding data connection
            connection.connect();
            //receive reponse
            int response = connection.getResponseCode();
            Log.i(getClass().getName(),"The response is: "+response);
            InputStream inputStream = connection.getInputStream();
            //Process image response
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}