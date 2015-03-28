package com.ecosteam.ecostream_android.ui;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecosteam.ecostream_android.Constant;
import com.ecosteam.ecostream_android.cloud.ParseDataFactory;
import com.ecosteam.ecostream_android.R;
import com.ecosteam.ecostream_android.cloud.RetrieveDataCallback;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PieChartFragment extends Fragment implements RetrieveDataCallback {
    private static final String TAG = "PieDisPlayFragment";


    private static int mSensorId;
    private TextView mLabel;
    private PieChart mPieChart;
    private PieModel mPositive;
    private PieModel mNegative;
    private Timer mTimer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        mSensorId = getArguments().getInt(MainFragment.KEY_SENSOR_ID, -1);

        if (mSensorId == R.id.sensor_1) {
            getActivity().getActionBar().setTitle(R.string.sensor_1);
        } else if (mSensorId == R.id.sensor_2) {
            getActivity().getActionBar().setTitle(R.string.sensor_2);
        }


        mPieChart = (PieChart) view.findViewById(R.id.piechart);
        mPositive = new PieModel("positive", 0, Color.parseColor("#56B7F1"));
        mNegative = new PieModel("negative", 100, Color.parseColor("#FE6DA8"));
        mPieChart.addPieSlice(mPositive);
        mPieChart.addPieSlice(mNegative);
        mPieChart.startAnimation();

        mLabel = (TextView) view.findViewById(R.id.label);
        mLabel.setText("0% flow rate");

        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            synchronized public void run() {
                if (mSensorId == R.id.sensor_1) {
                    ParseDataFactory.retrieveData(Constant.SENSOR_1_TABLE, 1, PieChartFragment.this);
                } else if (mSensorId == R.id.sensor_2) {
                    ParseDataFactory.retrieveData(Constant.SENSOR_2_TABLE, 1, PieChartFragment.this);
                }
            }
        }, 0, Constant.FETCHING_RATE_MILLIS);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }

    @Override
    public void retrieveDataCallback(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }


        int val = Integer.parseInt(list.get(0));
        updatePieChar(val);
    }

    private void updatePieChar(int val) {
        mPositive.setValue(val);
        mNegative.setValue(100 - val);
        mPieChart.update();

        mLabel.setText(val + "% flow rate");
    }
}
