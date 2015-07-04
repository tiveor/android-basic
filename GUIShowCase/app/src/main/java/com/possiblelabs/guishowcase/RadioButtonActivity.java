package com.possiblelabs.guishowcase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class RadioButtonActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_activity);

        final TextView tv = (TextView) findViewById(R.id.textView);

        final View.OnClickListener radioListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                tv.setText(rb.getText() + " chosen");
            }
        };

        final RadioButton choice1 = (RadioButton) findViewById(R.id.choice1);
        choice1.setOnClickListener(radioListener);

        final RadioButton choice2 = (RadioButton) findViewById(R.id.choice2);
        choice2.setOnClickListener(radioListener);

        final RadioButton choice3 = (RadioButton) findViewById(R.id.choice3);
        choice3.setOnClickListener(radioListener);

    }
}
