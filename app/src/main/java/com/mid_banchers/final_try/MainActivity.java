package com.mid_banchers.final_try;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mid_banchers.final_try.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
TabAdapter tabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        tabAdapter = new TabAdapter(this);
        binding.catPager.setAdapter(tabAdapter);
        new TabLayoutMediator(binding.cataTabs,binding.catPager, (TabLayout.Tab tab, int position) -> {
            if (position==0) {
                tab.setText("Light");
            }if (position==1) {
                tab.setText("Dark");
            }if (position==2) {
                tab.setText("Event");
            }if (position==3) {
                tab.setText("Bridal");
            }


        } ).attach();

    }
}