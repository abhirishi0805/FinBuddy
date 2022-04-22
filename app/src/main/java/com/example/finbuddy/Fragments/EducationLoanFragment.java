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
        benefits.setText("1- Interest rate of education loans are way cheaper than personal loans and government banks provide an additional concession of 0.5% to all female students. "+
                "2- One of the main benefit of education loan is the moratorium period. The moratorium period for an education loan includes course duration plus 6 months. "+"" +
                "3- Education loan also covers other expenses like tuition fees, travel (tickets), house rent, university fees, food expenses, etc. "+"" +
                "4- Taking an education loan can liberate parents from all financial burdens as the student is responsible to repay his/her education loan after the completion of his studies and the moratorium period. ");
        document_text.setText("1- KYC documents "+"" +
                "2- Bank Statement / Pass Book of last 6 months "+
                "3- Copy of admission letter of the Institute along with fees schedule "+
                "4- Mark sheets / passing certificates of S.S.C., H.S.C, Degree courses");
        return view;
    }
}
