package com.mid_banchers.final_try;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.mid_banchers.final_try.adapters.AdapterHome;
import com.mid_banchers.final_try.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AdapterHome adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        adapter = new AdapterHome(this);


        binding.include.rvlatestver.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                switch (adapter.getItemViewType(position)) {
                    case 0:
                        return 2;
                    case 1:
                        return 2;
                    case 2:
                        return 2;
                    default:
                        return 1;
                }
            }
        });


        binding.include.rvlatestver.setLayoutManager(gridLayoutManager);



     /*   tabAdapter = new TabAdapter(this);
        binding.catPager.setAdapter(tabAdapter);
        new TabLayoutMediator(binding.cataTabs, binding.catPager, (TabLayout.Tab tab, int position) -> {
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

        }).attach();*/

    }
}