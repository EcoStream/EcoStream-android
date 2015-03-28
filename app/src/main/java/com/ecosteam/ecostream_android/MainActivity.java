package com.ecosteam.ecostream_android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import com.ecosteam.ecostream_android.ui.MainFragment;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() == 1) {
            fm.popBackStack();
            getActionBar().setTitle(R.string.app_name);
            findViewById(R.id.content).setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}
