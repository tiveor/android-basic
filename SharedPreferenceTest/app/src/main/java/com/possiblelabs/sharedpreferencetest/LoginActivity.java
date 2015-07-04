package com.possiblelabs.sharedpreferencetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.possiblelabs.sharedpreferencetest.util.PreferenceUtil;

/**
 * Created by possiblelabs on 6/23/15.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button btn = (Button) findViewById(R.id.btn_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtil.setLoggedIn(LoginActivity.this, true);

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        if (PreferenceUtil.isLoggedIn(this)) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }
}
