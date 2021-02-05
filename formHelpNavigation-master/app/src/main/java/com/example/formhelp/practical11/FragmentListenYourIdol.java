package com.example.formhelp.practical11;

import android.media.MediaPlayer;
import android.os.Bundle;
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

public class FragmentListenYourIdol extends Fragment {
    private ImageView imgPlay;
    private ImageView imgPause;
    private ImageView imgStop;
    private MediaPlayer player;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listening_to_music,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgPlay = getActivity().findViewById(R.id.img_play_music);
        imgPause = getActivity().findViewById(R.id.img_pause_music);
        imgStop = getActivity().findViewById(R.id.img_stop);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });
        imgPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });
    }
    public void play(View view){
        Log.e(getClass().getName(),"Media play");
        if (player == null){
            player = MediaPlayer.create(getContext(),R.raw.edsheeran);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View view){
        Log.e(getClass().getName(),"Media pause");
        if (player != null){
            player.pause();
        }
    }
    public void stop(View view){
        Log.e(getClass().getName(),"Media stop");
        stopPlayer();
    }
    public void stopPlayer(){
        if (player!=null){
            player.release();
            player = null;
            Toast.makeText(getContext(),"Media Player",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }

}
