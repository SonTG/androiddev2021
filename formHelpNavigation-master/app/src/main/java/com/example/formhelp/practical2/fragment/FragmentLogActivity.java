package com.example.formhelp.practical2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.formhelp.R;
import com.example.formhelp.practical2.activity.LogActivity;

import pl.droidsonroids.gif.GifImageView;

public class FragmentLogActivity extends Fragment implements View.OnClickListener {
    private GifImageView imgViewG;
    private TextView textViewClickMove;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move,container,false);
        Log.i(getClass().getName(),"onCreateView created");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgViewG = getActivity().findViewById(R.id.img_gif);
        textViewClickMove = getActivity().findViewById(R.id.tv_click_activity);
        textViewClickMove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_click_activity:
                Intent intent = new Intent(this.getActivity(), LogActivity.class);
                startActivity(intent);
                break;
        }
    }
}
