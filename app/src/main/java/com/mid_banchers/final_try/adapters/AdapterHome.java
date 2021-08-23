package com.mid_banchers.final_try.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.final_try.MainActivity;
import com.mid_banchers.final_try.R;
import com.mid_banchers.final_try.TabAdapter;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final MainActivity context;

    public AdapterHome(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_0, parent, false);
            return new HolderX(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_1, parent, false);
            return new HolderA(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_1_heading, parent, false);
            return new HolderY(view);
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

        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position > 2) {
            return 3;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class HolderX extends RecyclerView.ViewHolder {
        ViewPager2 viewPager;
        TabLayout tabLayout;

        public HolderX(@NonNull View itemView) {
            super(itemView);

            viewPager = itemView.findViewById(R.id.cat_pager);
            tabLayout = itemView.findViewById(R.id.cata_tabs);
            viewPager.setUserInputEnabled(false);

 
            viewPager.setAdapter(new TabAdapter(context));
            viewPager.setUserInputEnabled(false);

            TabAdapter tabAdapter = new TabAdapter((FragmentActivity) context);
            viewPager.setAdapter(tabAdapter);


            new TabLayoutMediator(tabLayout, viewPager, (TabLayout.Tab tab, int position) -> {
                if (position == 0) {
                    tab.setText("Light");
                }
                if (position == 1) {
                    tab.setText("Dark");
                }
                if (position == 2) {
                    tab.setText("Event");
                }
                if (position == 3) {
                    tab.setText("Bridal");
                }
            }).attach();

        }
    }

    public class HolderY extends RecyclerView.ViewHolder {
        public HolderY(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class HolderA extends RecyclerView.ViewHolder {


        public HolderA(@NonNull View itemView) {
            super(itemView);

            String name = "Umair";


        }
    }
}
