package com.ecosteam.ecostream_android.cloud;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ParseDataFactory {
    public static final String TAG = "ParseDataFactory";

    public static void retrieveData(String tableName, int number, final RetrieveDataCallback callback) {
        // Set up query
        ParseQuery<ParseObject> query = ParseQuery.getQuery(tableName);
        query.orderByDescending("createdAt");
        query.setLimit(number);

        // Start query
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {

                    List<String> res = new ArrayList<String>();
                    for (ParseObject p : list) {
                        res.add(p.getString("data"));
                    }

                    callback.retrieveDataCallback(res);
                } else {
                    Log.e(TAG, "Retrieve data failed " + e.getMessage());
                    callback.retrieveDataCallback(null);
                }
            }
        });
    }
}
