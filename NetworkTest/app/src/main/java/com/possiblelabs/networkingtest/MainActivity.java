package com.possiblelabs.networkingtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadEarthquakesJSON(View v) {
        Intent intent = new Intent(MainActivity.this, EarthQuakesList.class);
        intent.putExtra("TYPE", "JSON");
        startActivity(intent);
    }

    public void loadEarthquakesXML(View v) {
        Intent intent = new Intent(MainActivity.this, EarthQuakesList.class);
        intent.putExtra("TYPE", "XML");
        startActivity(intent);
    }
}
