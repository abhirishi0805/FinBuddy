package com.example.finbuddy.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Area3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.example.finbuddy.R;

import java.util.ArrayList;


public class TaxFragment extends Fragment {
    TextView btnTaxCalculator;

    AnyChartView anyChartView1;
    AnyChartView anyChartView2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tax, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anyChartView1 = view.findViewById(R.id.any_chart);
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);
        ArrayList<DataEntry> seriesData = new ArrayList<>();

        seriesData.add(new ValueDataEntry(0, 0));
        seriesData.add(new ValueDataEntry(250000, 0));
        seriesData.add(new ValueDataEntry(250001, 5));
        seriesData.add(new ValueDataEntry(500000, 5));
        seriesData.add(new ValueDataEntry(500001, 10));
        seriesData.add(new ValueDataEntry(750000, 10));
        seriesData.add(new ValueDataEntry(750001, 15));
        seriesData.add(new ValueDataEntry(1000000, 15));
        seriesData.add(new ValueDataEntry(1000001, 20));
        seriesData.add(new ValueDataEntry(1250000, 20));
        seriesData.add(new ValueDataEntry(1250001, 25));
        seriesData.add(new ValueDataEntry(1500000, 25));
        seriesData.add(new ValueDataEntry(1500001, 30));
        seriesData.add(new ValueDataEntry(2000000, 30));
        draw_graph(seriesData, "Income (in ₹)", "Percentage Tax", anyChartView1);
        seriesData.clear();

        anyChartView2 = view.findViewById(R.id.any_chart_second);
        APIlib.getInstance().setActiveAnyChartView(anyChartView2);

        seriesData.add(new ValueDataEntry(0, 0));
        seriesData.add(new ValueDataEntry(250000, 0));
        seriesData.add(new ValueDataEntry(250001, 5));
        seriesData.add(new ValueDataEntry(500000, 5));
        seriesData.add(new ValueDataEntry(500001, 20));
        seriesData.add(new ValueDataEntry(1000000, 20));
        seriesData.add(new ValueDataEntry(1000001, 30));
        seriesData.add(new ValueDataEntry(2000000, 30));

        draw_graph(seriesData, "Income (in ₹)", "Percentage Tax", anyChartView2);

        btnTaxCalculator = view.findViewById(R.id.btnTaxCalculator);
        btnTaxCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_taxFragment2_to_taxCalculatorFragment2);
            }
        });
    }


    void draw_graph(ArrayList<DataEntry> list, String x, String y, AnyChartView anyChartView) {
        Cartesian3d area3d = AnyChart.area3d();
        area3d.xAxis(0).labels().format("{%Value}");
        area3d.animation(true);

        area3d.yAxis(0).title(y);
        area3d.xAxis(0).title(x);
        area3d.xAxis(0).labels().padding(5.0, 5.0, 0.0, 5.0);
        area3d.title().useHtml(true);
        area3d.title().padding(0.0, 0.0, 20.0, 0.0);


        Set set = Set.instantiate();
        set.data(list);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Area3d series1 = area3d.area(series1Data);
        series1.name("Tax%");
        series1.hovered().markers(true);
        anyChartView.setChart(area3d);
    }

}
