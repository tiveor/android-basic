package com.possiblelabs.sharedpreferencetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.possiblelabs.sharedpreferencetest.util.PreferenceUtil;

/**
 * Created by possiblelabs on 6/23/15.
 */
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button btn = (Button) findViewById(R.id.btn_logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtil.setLoggedIn(HomeActivity.this, false);
                HomeActivity.this.finish();
            }
        });
    }
}
