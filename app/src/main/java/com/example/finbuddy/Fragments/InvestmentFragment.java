package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finbuddy.R;
import com.white.progressview.HorizontalProgressView;

public class InvestmentFragment extends Fragment {

    HorizontalProgressView progress_fd, progress_equity, progress_mf, progress_real_estate, progress_gold;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_investment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        progress_fd = view.findViewById(R.id.progress_fd);
        progress_equity = view.findViewById(R.id.progress_equity);
        progress_mf = view.findViewById(R.id.progress_mf);
        progress_real_estate = view.findViewById(R.id.progress_real_estate);
        progress_gold = view.findViewById(R.id.progress_gold);

        progress_fd.setProgressInTime(0, 1000);
        progress_equity.setProgressInTime(0, 1200);
        progress_mf.setProgressInTime(0, 1100);
        progress_real_estate.setProgressInTime(0, 1000);
        progress_gold.setProgressInTime(0, 1050);
    }
}
