package com.possiblelabs.filemanagertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by possiblelabs on 9/22/15.
 */
public class MainActivity extends Activity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
    }

    public void doExternal(View view) {
        Intent i = new Intent(MainActivity.this, ExternalFileWriteReadActivity.class);
        startActivity(i);
    }

    public void doInternal(View view) {
        Intent i = new Intent(MainActivity.this, InternalFileWriteReadActivity.class);
        startActivity(i);
    }
}
