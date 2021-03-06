package com.mid_banchers.final_try;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mid_banchers.final_try.adapters.AdapterHome;
import com.mid_banchers.final_try.adapters.DataModel;
import com.mid_banchers.final_try.adapters.NewAdapter;
import com.mid_banchers.final_try.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
FirebaseFirestore fs = FirebaseFirestore.getInstance();
    ActivityMainBinding binding;
    AdapterHome adapter;
    DataModel dataModel;
    //NewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        adapter = new AdapterHome(MainActivity.this);
        //adapter = new NewAdapter();
        fs.collection("Mehndi Designs").document("Recycle 0")
                .get().addOnSuccessListener(documentSnapshot -> {
                    dataModel = documentSnapshot.toObject(DataModel.class);
                    adapter.getData(dataModel);
                });



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


/*

        tabAdapter = new TabAdapter(MainActivity.this);
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

        }).attach();
*/

    }
}