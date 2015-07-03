/*
 * Copyright (C) 2012 The Android Open Source Project
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package com.possiblelabs.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by possiblelabs on 6/29/15.
 */
public class ActivityDialog extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
    }

    public void finishDialog(View v) {
        ActivityDialog.this.finish();
    }
}