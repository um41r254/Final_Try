package com.mid_banchers.final_try;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mid_banchers.final_try.databinding.LatestRvLayoutBinding;

public class VerticalRv extends RecyclerView.Adapter<VerticalRv.VerticalViewHolder> {
public Context context;

    public VerticalRv(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LatestRvLayoutBinding view = LatestRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        LatestRvLayoutBinding binding;
        public VerticalViewHolder(@NonNull LatestRvLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
