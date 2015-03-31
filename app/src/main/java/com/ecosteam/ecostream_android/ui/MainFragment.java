package com.ecosteam.ecostream_android.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecosteam.ecostream_android.R;

public class MainFragment extends Fragment {

    private static final String TAG = "ListFragment";
    public static final String KEY_SENSOR_ID = "sensor_id";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Sensor 1 button
        View sensor_1 = view.findViewById(R.id.sensor_1);
        sensor_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPieFragment(R.id.sensor_1);
            }
        });

        // Sensor 2 button
        View sensor_2 = view.findViewById(R.id.sensor_2);
        sensor_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPieFragment(R.id.sensor_2);
            }
        });

        // Sensor 3 button
        View sensor_3 = view.findViewById(R.id.sensor_3);
        sensor_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPieFragment(R.id.sensor_3);
            }
        });

        // Sensor 4 button
        View sensor_4 = view.findViewById(R.id.sensor_4);
        sensor_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPieFragment(R.id.sensor_4);
            }
        });

        View line_char = view.findViewById(R.id.line_chart);
        line_char.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainFragment.this.getActivity(), LineChartActivity.class);
                startActivity(intent);
                MainFragment.this.getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        return view;
    }

    private void startPieFragment(int sensorId) {
        Fragment fragment = new PieChartFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_SENSOR_ID, sensorId);
        fragment.setArguments(args);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in_backstack, R.anim.slide_out_backstack)
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();

        getActivity().findViewById(R.id.content).setVisibility(View.GONE);
    }
}
