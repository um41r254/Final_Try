package com.mid_banchers.final_try;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mid_banchers.final_try.Adapters.HorizontalRv;
import com.mid_banchers.final_try.Adapters.VerticalRv;
import com.mid_banchers.final_try.databinding.FragmentTab1Binding;

public class Tab1 extends Fragment {
HorizontalRv adapter;
VerticalRv verticalRv;

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
        binding.rvcatagoryHori.setAdapter(adapter);
        binding.rvcatagoryHori.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,true));


    }
}