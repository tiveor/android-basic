/*
 * Copyright (C) 2012 The Android Open Source Project
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package com.possiblelabs.lifecycle.utils;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tivesoft on 6/29/15.
 */
public class StatusPrinter {

    private static StatusTracker mStatusTracker = StatusTracker.getInstance();

    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if (viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0, key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if (viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }
}
