package com.mid_banchers.final_try.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mid_banchers.final_try.R;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.catagories_rv_layout, parent, false);
            return new HolderX(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.latest_rv_layout, parent, false);
            return new HolderY(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {

        if (position < 10) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 120;
    }

    public class HolderX extends RecyclerView.ViewHolder {

        public HolderX(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class HolderY extends RecyclerView.ViewHolder {
        public HolderY(@NonNull View itemView) {
            super(itemView);
        }
    }
}
