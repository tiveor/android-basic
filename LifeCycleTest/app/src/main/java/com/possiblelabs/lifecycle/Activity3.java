/*
 * Copyright (C) 2012 The Android Open Source Project
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package com.possiblelabs.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.possiblelabs.lifecycle.utils.StatusPrinter;
import com.possiblelabs.lifecycle.utils.StatusTracker;

/**
 * Created by tivesoft on 6/29/15.
 */
public class Activity3 extends Activity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        mActivityName = getString(R.string.activity_c_label);
        mStatusView = (TextView)findViewById(R.id.status_view_c);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_c);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        StatusPrinter.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        StatusPrinter.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        StatusPrinter.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        StatusPrinter.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        StatusPrinter.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
    }

    public void startDialog(View v) {
        Intent intent = new Intent(Activity3.this, ActivityDialog.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(Activity3.this, Activity1.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(Activity3.this, Activity2.class);
        startActivity(intent);
    }

    public void finishActivityC(View v) {
        Activity3.this.finish();
    }
}
