package com.example.formhelp.practical12;

import android.content.Intent;
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

import org.jsoup.helper.HttpConnection;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FragmentToolbar extends Fragment implements View.OnClickListener {
    private ImageView imgActivitySwipe;
    private ImageView imgReload;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgReload = getActivity().findViewById(R.id.img_reload);
        imgActivitySwipe = getActivity().findViewById(R.id.img_setting);
        imgReload.setOnClickListener(this);
        imgActivitySwipe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_reload:
//                reload();
//                requestNetwork();
                //task.execute();
                break;
            case R.id.img_setting:
                startActivity(new Intent(this.getActivity(),PrefActivity.class));
                break;
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
                        Bundle bundle = new Bundle();
                        bundle.putString("server_response","No Internet connection");
                        Message msg = new Message();
                        msg.setData(bundle);
                        handler1.sendMessage(msg);
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
                handler1 = new Handler(Looper.getMainLooper()){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        String content = msg.getData().getString("server_response");
                        Toast.makeText(getContext(),content,Toast.LENGTH_LONG).show();
                    }
                };
            }
        };
    private void reload() {
        final Handler handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                String content = msg.getData().getString("server_response");
                Toast.makeText(getContext(),content,Toast.LENGTH_LONG).show();
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Bundle bundle = new Bundle();
                bundle.putString("server_response","some sample json here");
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }

        });
        thread.start();
    }
}
