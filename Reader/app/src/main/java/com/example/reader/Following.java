package com.example.reader;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class Following extends Fragment {


    public Following() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_following, container, false);
        Button like = (Button) v.findViewById(R.id.btn_following);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Discover discover = new Discover();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, discover);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return v;
    }
}