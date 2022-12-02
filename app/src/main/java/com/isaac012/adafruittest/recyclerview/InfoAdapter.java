package com.isaac012.adafruittest.recyclerview;

import android.content.Context;
import android.service.controls.Control;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isaac012.adafruittest.R;
import com.isaac012.adafruittest.models.Feed;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder> {
    List<Feed> feedList;
    Context ctx;

    public InfoAdapter(List<Feed> feedList, Context ctx) {
        this.feedList = feedList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new InfoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Feed feed = feedList.get(position);
        holder.userView.setText(feedList.get(position).getUsername());
        holder.idView.setText(String.valueOf(feedList.get(position).getId()));
        holder.nameView.setText(feedList.get(position).getName());
        holder.valueView.setText(feedList.get(position).getLast_value());
        holder.createdView.setText(feedList.get(position).getCreated_at());
        holder.keyView.setText(feedList.get(position).getKey());
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }
}
