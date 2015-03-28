package com.ecosteam.ecostream_android;

import android.app.Application;

import com.parse.Parse;

public class EcoStreamApplication extends Application {

    private static final String PARSE_APP_ID = "5dYyy3c3vgllE0btqL9N0rsbvzC0nj1t55c8wW8b";
    private static final String PARSE_CLIENT_KEY = "f6CjZroj4Qys8Mr1MSjHobg98voeo2a2RAtCZ7bF";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, PARSE_APP_ID, PARSE_CLIENT_KEY);
    }
}
