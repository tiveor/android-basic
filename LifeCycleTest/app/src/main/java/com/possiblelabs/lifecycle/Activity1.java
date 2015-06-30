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
public class Activity1 extends Activity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        mActivityName = getString(R.string.activity_a);
        mStatusView = (TextView) findViewById(R.id.status_view_a);
        mStatusAllView = (TextView) findViewById(R.id.status_view_all_a);
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
        mStatusTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(Activity1.this, ActivityDialog.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(Activity1.this, Activity2.class);
        startActivity(intent);
    }

    public void startActivityC(View v) {
        Intent intent = new Intent(Activity1.this, Activity3.class);
        startActivity(intent);
    }

    public void finishActivityA(View v) {
        Activity1.this.finish();
    }

}
