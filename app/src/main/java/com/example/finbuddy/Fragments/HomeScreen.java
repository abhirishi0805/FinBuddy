package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;


import com.example.finbuddy.R;
import com.example.finbuddy.adapter.sliderAdapter;

import java.util.ArrayList;


public class HomeScreen extends Fragment {

    CardView card_tax, card_investment, card_education_loan;
    ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.background_white));

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        card_tax = view.findViewById(R.id.card_tax);
        card_investment = view.findViewById(R.id.card_investment);
        card_education_loan = view.findViewById(R.id.card_education_loan);
        viewPager2 = view.findViewById(R.id.view_pager2);

        NavController navController = Navigation.findNavController(view);


         ArrayList<Integer> arr =  new ArrayList<Integer>();
         arr.add(R.drawable.photo_one);
         arr.add(R.drawable.photo_three);
         arr.add(R.drawable.photo_two);

        sliderAdapter adapter  = new sliderAdapter(getContext(), arr , viewPager2 );
        viewPager2.setAdapter(adapter);

        card_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeScreen2_to_taxFragment2);
            }
        });

        card_investment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeScreen2_to_investmentFragment2);
            }
        });

        card_education_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeScreen2_to_investmentFragment2);
            }
        });
    }
}
