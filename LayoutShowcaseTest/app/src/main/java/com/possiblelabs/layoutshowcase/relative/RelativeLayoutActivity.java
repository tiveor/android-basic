package com.possiblelabs.layoutshowcase.relative;

//Copyright (c) 2015 Adam Porter
//Code extracted from: https://github.com/aporter/coursera-android

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.possiblelabs.layoutshowcase.R;

/**
 * Created by possiblelabs on 6/30/15.
 */
public class RelativeLayoutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);

        final EditText textEntry = (EditText) findViewById(R.id.entry);

        final Button cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textEntry.setText("");
            }
        });

        final Button okButton = (Button) findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RelativeLayoutActivity.this.finish();
            }
        });
    }
}
