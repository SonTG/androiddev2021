package com.example.formhelp.practical6.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.formhelp.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FragmentForecast1 extends Fragment {
    ImageView img;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forcast_1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        img = getActivity().findViewById(R.id.img_cloud);
        task.execute();
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
            img.setImageBitmap(bitmap);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Handler handler1;
    final AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
        @Override
        protected Bitmap doInBackground(String... strings) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    downloadImage();
                }
            });
            thread.start();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
//            handler1 = new Handler(Looper.getMainLooper()){
//                @Override
//                public void handleMessage(@NonNull Message msg) {
//                    String content = msg.getData().getString("server_response");
//                    Toast.makeText(getContext(),content,Toast.LENGTH_LONG).show();
//                }
//            };
        }
    };
}
