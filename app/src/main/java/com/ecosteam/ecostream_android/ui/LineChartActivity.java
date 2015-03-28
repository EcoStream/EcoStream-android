package com.ecosteam.ecostream_android.ui;

import android.app.Activity;
import android.os.Bundle;

import com.ecosteam.ecostream_android.R;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class LineChartActivity extends Activity {
    private ValueLineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        mLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);
        addCharData();
    }

    private void addCharData() {
        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF56B7F1);

        series.addPoint(new ValueLinePoint("9:00", 34));
        series.addPoint(new ValueLinePoint("10:00", 35));
        series.addPoint(new ValueLinePoint("11:00", 43));
        series.addPoint(new ValueLinePoint("12:00", 67));
        series.addPoint(new ValueLinePoint("13:00", 64));
        series.addPoint(new ValueLinePoint("14:00", 55));
        series.addPoint(new ValueLinePoint("15:00", 43));
        series.addPoint(new ValueLinePoint("16:00", 32));
        series.addPoint(new ValueLinePoint("17:00", 31));
        series.addPoint(new ValueLinePoint("18:00", 36));
        series.addPoint(new ValueLinePoint("19:00", 46));
        series.addPoint(new ValueLinePoint("20:00", 69));

        mLineChart.addSeries(series);
        mLineChart.startAnimation();
    }
}
