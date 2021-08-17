package com.mid_banchers.final_try.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mid_banchers.final_try.databinding.CatagoriesRvLayoutBinding;

public class HorizontalRv extends RecyclerView.Adapter<HorizontalRv.HorizontalViewHolder> {

private Context context;

    public HorizontalRv(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { CatagoriesRvLayoutBinding view = CatagoriesRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        CatagoriesRvLayoutBinding binding;
        public HorizontalViewHolder(@NonNull CatagoriesRvLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
