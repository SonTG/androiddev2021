package com.example.formhelp.practical5.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.formhelp.R;
import com.example.formhelp.practical5.status.Status;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterStatus extends RecyclerView.Adapter<AdapterStatus.MyHolder> {
    private ArrayList<Status>statuses;
    private Context context;

    public AdapterStatus(ArrayList<Status> statuses, Context context) {
        this.statuses = statuses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_weather,parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvStatus.setText(statuses.get(position).getStatus());
        holder.date.setText(statuses.get(position).getDate());
        holder.degree1.setText(statuses.get(position).getDegree_1());
        holder.degree2.setText(statuses.get(position).getDegree_2());
        Picasso.get().load(statuses.get(position).getIconWeather()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        private TextView tvStatus;
        private TextView degree1;
        private TextView degree2;
        private ImageView imgIcon;
        private TextView date;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.tv_status);
            degree1 = itemView.findViewById(R.id.tv_degree_1);
            degree2 = itemView.findViewById(R.id.tv_degree_2);
            date = itemView.findViewById(R.id.tv_date);
            imgIcon = itemView.findViewById(R.id.img_icon_status);
        }
    }
}
