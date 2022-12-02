package com.isaac012.adafruittest.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isaac012.adafruittest.R;

public class InfoViewHolder extends RecyclerView.ViewHolder {
    TextView userView;
    TextView idView;
    TextView nameView;
    TextView valueView;
    TextView createdView;
    TextView keyView;

    public InfoViewHolder(@NonNull View v) {
        super(v);

        userView = v.findViewById(R.id.userView);
        idView = v.findViewById(R.id.idView);
        nameView = v.findViewById(R.id.nameView);
        valueView = v.findViewById(R.id.valueView);
        createdView = v.findViewById(R.id.createdView);
        keyView = v.findViewById(R.id.keyView);
    }
}
