package com.example.finbuddy.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finbuddy.R;
import com.example.finbuddy.adapter.LoanAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EducationLoanFragment extends Fragment {
    List<String> l,l1;
    Context ctx;
    LoanAdapter adapter;
    RecyclerView rV,rV1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education_loan, container, false);
        rV=view.findViewById(R.id.recycler_view);
        rV1=view.findViewById(R.id.recycler_view1);
        l = new ArrayList<>();
        l1 = new ArrayList<>();
        rV.setHasFixedSize(true);
        rV.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV1.setHasFixedSize(true);
        rV1.setLayoutManager(new LinearLayoutManager(getActivity()));
        ctx=getContext();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        DocumentReference ref=db.collection("EducationLoan").document("Benefit");
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    Map<String, Object> c =documentSnapshot.getData();
                    for(int i=0;i<c.size();i++){
                        String s=String.valueOf(i);
                        String a=String.valueOf(i+1);
                        l.add(a+"- "+(String) c.get(s));
                    }
                    adapter = new LoanAdapter(l,ctx);
                    rV.setAdapter(adapter);
                }
            }
        });
        DocumentReference ref1=db.collection("EducationLoan").document("DocumentRequired");
        ref1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    Map<String, Object> c =documentSnapshot.getData();
                    for(int i=0;i<c.size();i++){
                        String s=String.valueOf(i);
                        String a=String.valueOf(i+1);
                        l1.add(a+"- "+(String) c.get(s));
                    }
                    adapter = new LoanAdapter(l1,ctx);
                    rV1.setAdapter(adapter);
                }
            }
        });
        return view;
    }
}
