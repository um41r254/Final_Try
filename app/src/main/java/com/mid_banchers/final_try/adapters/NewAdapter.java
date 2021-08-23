package com.mid_banchers.final_try.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.mid_banchers.final_try.databinding.CatagoriesRvLayoutBinding;
import com.mid_banchers.final_try.databinding.LatestRvLayoutBinding;

public class NewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == 0) {
            LatestRvLayoutBinding binding1 = LatestRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                    parent, false);
            return new HolderX(binding1);
        } else {
            CatagoriesRvLayoutBinding binding1 = CatagoriesRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                    parent, false);
            return new HolderB(binding1);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class HolderX extends RecyclerView.ViewHolder {
        LatestRvLayoutBinding binding;

        public HolderX(@NonNull LatestRvLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }

    public class HolderB extends RecyclerView.ViewHolder {
        CatagoriesRvLayoutBinding binding;

        public HolderB(@NonNull CatagoriesRvLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

}
