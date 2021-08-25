package com.mid_banchers.final_try.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mid_banchers.final_try.databinding.CatagoriesRvLayoutBinding;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HorizontalRv extends RecyclerView.Adapter<HorizontalRv.HorizontalViewHolder> {
List<String> images = new ArrayList<>();
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
        if (images.size()>0) {
            Glide.with(context).load(images.get(position)).into(holder.binding.catagoryImage);
        }

    }

    @Override
    public int getItemCount() {
        if (images.size()>0) {
            return images.size();
        }
        else return 4;
    }

    public  void getData( List<String> data){

        images.addAll(data);
        notifyDataSetChanged();
        Log.d(TAG, "getData: done"+images.size());

    }
    public  void getData2( List<String> data){


        images.addAll(data);
        notifyDataSetChanged();
        Log.d(TAG, "getData: done"+images.size());

    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        CatagoriesRvLayoutBinding binding;
        public HorizontalViewHolder(@NonNull CatagoriesRvLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
