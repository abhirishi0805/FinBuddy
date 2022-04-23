package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import com.example.finbuddy.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class EducationLoanFragment extends Fragment {
    ListView benefits,document_text;
    List<String> benefit_loan,document_loan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education_loan, container, false);
        benefits=view.findViewById(R.id.benefit_of_loan);
        document_text=view.findViewById(R.id.document_text);
        benefit_loan=new ArrayList<String>();
        document_loan=new ArrayList<String>();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("EducationLoan").document("Benefit").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

            }
        });
        ArrayAdapter<String> arr= new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,benefit_loan);
        benefits.setAdapter(arr);
        ArrayAdapter<String> arr1= new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,document_loan);
        document_text.setAdapter(arr1);
        return view;
    }
}
