package com.example.formhelp.practical12;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.formhelp.R;

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
                Toast.makeText(getContext(),"Reload !",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_setting:
                startActivity(new Intent(this.getActivity(),PrefActivity.class));
                break;
        }
    }
}
