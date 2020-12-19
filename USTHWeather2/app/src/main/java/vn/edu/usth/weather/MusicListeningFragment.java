package vn.edu.usth.weather;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MusicListeningFragment extends Fragment {
    private MediaPlayer player;
    private Button play_btn;
    private Button pause_btn;
    private Button stop_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.musiclistening_layout, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        play_btn = getActivity().findViewById(R.id.play_btn);
        pause_btn = getActivity().findViewById(R.id.pause_btn);
        stop_btn = getActivity().findViewById(R.id.stop_btn);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });
    }

    public void play (View view){
        if (player == null) {
            player = MediaPlayer.create(getContext(), R.raw.milkyway);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause (View view){
        if (player != null) {
            player.pause();
        }
    }

    public void stop (View view){
        stopPlayer();
        stopPlayer();
    }

    private void stopPlayer () {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(getContext(), "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

}
