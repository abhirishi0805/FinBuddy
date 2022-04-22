package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.finbuddy.R;

public class EducationLoanFragment extends Fragment {
    TextView benefits,document_text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education_loan, container, false);
        benefits=view.findViewById(R.id.benefit_of_loan);
        document_text=view.findViewById(R.id.document_text);

        return view;
    }
}
