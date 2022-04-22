package com.example.finbuddy.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finbuddy.R;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner taxType;
    EditText amount;
    Button calculate_tax;
    TextView tax_amount;
    String item="New Regime";
    int totalamount;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tax_calculator, container, false);
        taxType=view.findViewById(R.id.taxType);
        taxType.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("New Regime");
        categories.add("Old Regime");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taxType.setAdapter(dataAdapter);
        amount=view.findViewById(R.id.amount);
        totalamount=Integer.parseInt(amount.getText().toString());
        calculate_tax=view.findViewById(R.id.calculate_tax);
        tax_amount=view.findViewById(R.id.tax_amount);
        calculate_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void calculate(){
        double tax=0;
        if(item.equals("New Regime")){
            if(totalamount<=250000)
                tax=0;
            else if(totalamount<=500000){
                double y=(double)(totalamount-250000);
                y=(double)(y*5)/(double)100;
                tax+=y;
            }
            else if(totalamount<=750000){
                tax+=(double)12500;
                double y=(double)(totalamount-500000);
                y=(double)(y*10)/(double)100;
                tax+=y;
            }
            else if(totalamount<=1000000){
                tax+=(double)38000;
                double y=(double)(totalamount-750000);
                y=(double)(y*15)/(double)100;
                tax+=y;
            }
            else if(totalamount<=1250000){
                tax+=(double)75500;
                double y=(double)(totalamount-1000000);
                y=(double)(y*20)/(double)100;
                tax+=y;
            }
            else if(totalamount<=1500000){
                tax+=(double)125500;
                double y=(double)(totalamount-1250000);
                y=(double)(y*25)/(double)100;
                tax+=y;
            }
            else {
                tax += (double) 188000;
                double y = (double) (totalamount - 1500000);
                y = (double) (y * 30) / (double) 100;
                tax += y;
            }
        }
        else{
            if(totalamount<=250000)
                tax=0;
            else if(totalamount<=500000){
                double y=(double)(totalamount-250000);
                y=(double)(y*5)/(double)100;
                tax+=y;
            }
            else if(totalamount<=1000000){
                tax+=(double)12500;
                double y=(double)(totalamount-500000);
                y=(double)(y*20)/(double)100;
                tax+=y;
            }
            else{
                tax+=(double)112500;
                double y=(double)(totalamount-100000);
                y=(double)(y*30)/(double)100;
                tax+=y;
            }
        }
        tax_amount.setText(String.valueOf(tax));
    }
}