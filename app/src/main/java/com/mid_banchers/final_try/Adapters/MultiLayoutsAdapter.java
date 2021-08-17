package com.mid_banchers.final_try.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mid_banchers.final_try.databinding.CatagoriesRvLayoutBinding;
import com.mid_banchers.final_try.databinding.LatestRvLayoutBinding;

public class MultiLayoutsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public MultiLayoutsAdapter(Context context) {
        this.context = context;
    }

    Context context;
    private static final String TAG = "yes";
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType ==0){
            LatestRvLayoutBinding view1 = LatestRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new Holder1(view1);
        }else {
            Log.d(TAG, "onCreateViewHolder: ");
            CatagoriesRvLayoutBinding view2 = CatagoriesRvLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Holder2(view2);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position<10){
            return 0;
        }
        else
            return 1;
    }

    @Override
    public int getItemCount() {
        return 20;
    }
    LatestRvLayoutBinding latestRvLayoutBinding;
    CatagoriesRvLayoutBinding catagoriesRvLayoutBinding;
    public class Holder1 extends RecyclerView.ViewHolder {
        public Holder1(@NonNull LatestRvLayoutBinding itemView) {
            super(itemView.getRoot());
            latestRvLayoutBinding = itemView;
        }
    }
    public class Holder2 extends RecyclerView.ViewHolder {
        public Holder2(@NonNull CatagoriesRvLayoutBinding itemView) {
            super(itemView.getRoot());
            catagoriesRvLayoutBinding= itemView;
        }
    }
}
