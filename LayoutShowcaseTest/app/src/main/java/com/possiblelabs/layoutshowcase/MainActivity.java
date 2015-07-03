package com.possiblelabs.layoutshowcase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.possiblelabs.layoutshowcase.grid.GridLayoutActivity;
import com.possiblelabs.layoutshowcase.linear.LinearLayoutActivity;
import com.possiblelabs.layoutshowcase.relative.RelativeLayoutActivity;
import com.possiblelabs.layoutshowcase.tab.TabLayoutActivity;
import com.possiblelabs.layoutshowcase.table.TableLayoutActivity;

/**
 * Created by tivesoft on 6/29/15.
 */
public class MainActivity extends Activity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
    }

    public void loadLinearLayout(View view) {
        Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
        startActivity(intent);
    }

    public void loadRelativeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
        startActivity(intent);
    }

    public void loadGridLayout(View view) {
        Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
        startActivity(intent);
    }

    public void loadTabLayout(View view) {
        Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
        startActivity(intent);
    }

    public void loadTableLayout(View view) {
        Intent intent = new Intent(MainActivity.this, TableLayoutActivity.class);
        startActivity(intent);
    }
}
