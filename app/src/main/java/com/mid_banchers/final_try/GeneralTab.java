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

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mid_banchers.final_try.adapters.HorizontalRv;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class GeneralTab extends Fragment {
    HorizontalRv adapter;
    String tabName;
    List<String> generalData= new ArrayList<>();
    FirebaseFirestore fd = FirebaseFirestore.getInstance();

    public void setTabName(String tabName) {
        this.tabName = tabName;
        Log.d(TAG, "setTabName: "+tabName);
    }

    public GeneralTab() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_general_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        super.onViewCreated(view, savedInstanceState);
        adapter = new HorizontalRv(getContext());
        recyclerView = view.findViewById(R.id.generalTabHrv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
getData();

    }


    public void  getData(){
        fd.collection("Mehndi Designs")
                .whereEqualTo("tab",tabName).addSnapshotListener((value, error) -> {
                    if (!value.isEmpty()){
                        for (DocumentSnapshot ds: value.getDocuments()){
                            generalData.add(ds.get("image").toString());
                            Log.d(TAG, "getData: Tab"+ds.get("tab"));

                        }
                        adapter.getData(generalData);

                    }


        });


    }
}