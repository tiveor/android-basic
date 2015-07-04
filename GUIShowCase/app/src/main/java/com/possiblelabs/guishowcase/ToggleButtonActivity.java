package com.possiblelabs.guishowcase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class ToggleButtonActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglebutton_activity);
        final LinearLayout bg = (LinearLayout) findViewById(R.id.linearlayout);
        final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    bg.setBackgroundColor(0xFFF3F3F3);
                } else {
                    bg.setBackgroundColor(0xFF000000);
                }
            }
        });

    }
}
