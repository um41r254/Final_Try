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
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mid_banchers.final_try.adapters.HorizontalRv;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Tab3 extends Fragment {
    HorizontalRv adapter;
    List<String> dataList = new ArrayList<>();
    FirebaseFirestore fb = FirebaseFirestore.getInstance();


    public Tab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        super.onViewCreated(view, savedInstanceState);
        adapter=new HorizontalRv(getContext());
        recyclerView= view.findViewById(R.id.tab3Hrv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        fireData();
    }
    public void fireData(){
        fb.collection("Mehndi Designs")
                .whereEqualTo("tab","Event").addSnapshotListener((value, error) -> {
                    for (DocumentSnapshot ds : value.getDocuments())
                    if (ds.exists()) {
                        dataList.clear();
                        dataList.add(ds.get("image").toString());
                        Log.d(TAG, "fireData: Event" + ds.get("tab"));
                        adapter.getData(dataList);
                    }
                });


}
}