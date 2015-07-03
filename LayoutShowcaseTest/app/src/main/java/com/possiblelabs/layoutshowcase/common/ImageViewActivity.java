package com.possiblelabs.layoutshowcase.common;

//Copyright (c) 2015 Adam Porter
//Code extracted from: https://github.com/aporter/coursera-android

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.possiblelabs.layoutshowcase.grid.GridLayoutActivity;

/**
 * Created by possiblelabs on 6/30/15.
 */
public class ImageViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));

        setContentView(imageView);
    }
}
