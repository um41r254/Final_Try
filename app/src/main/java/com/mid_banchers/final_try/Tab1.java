package com.mid_banchers.final_try;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mid_banchers.final_try.adapters.HorizontalRv;
import com.mid_banchers.final_try.databinding.FragmentTab1Binding;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Tab1 extends Fragment {
HorizontalRv adapter;
List<String> dataList = new ArrayList<>();
FirebaseFirestore fb = FirebaseFirestore.getInstance();


    public Tab1() {

    }
FragmentTab1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTab1Binding.inflate(getLayoutInflater(),container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new HorizontalRv(getContext());
        binding.tab1Hrv.setAdapter(adapter);
        binding.tab1Hrv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        fireData();

    }

    private void fireData(){
        fb.collection("Mehndi Designs")
                .whereEqualTo("tab","Light")
                .addSnapshotListener((value, error) -> {
                    for (DocumentSnapshot ds : value.getDocuments()){
                        if (ds.exists()) {
                            dataList.clear();
                            dataList.add(ds.get("image").toString());
                            Log.d(TAG, "fireData: Light" + ds.get("tab"));
                            adapter.getData(dataList);
                        }

                    }

                });


    }
}