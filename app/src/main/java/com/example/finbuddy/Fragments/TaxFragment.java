package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finbuddy.R;


public class TaxFragment extends Fragment {
    TextView tax_info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tax, container, false);
        tax_info=view.findViewById(R.id.tax_info);
        tax_info.setText("Tax is the money paid to the government other than for transaction-specific goods and services. " +
                "Income tax is the most common tax in which a part of your income is paid to government. ");
        return view;
    }
}
