package com.example.finbuddy.Fragments.Bank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.finbuddy.R;

public class BankFragment extends Fragment {
    Button loan;
    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_bank, container, false);
    loan=view.findViewById(R.id.button_loan);
    loan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                if (getFragmentManager() != null) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container, new LoanFragment());
                    transaction.commit();
                }
        }
    });
    return view;
}

}
