package com.possiblelabs.layoutshowcase.grid;

//Copyright (c) 2015 Adam Porter
//Code extracted from: https://github.com/aporter/coursera-android

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.possiblelabs.layoutshowcase.R;
import com.possiblelabs.layoutshowcase.common.ImageAdapter;
import com.possiblelabs.layoutshowcase.common.ImageViewActivity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by possiblelabs on 6/30/15.
 */
public class GridLayoutActivity extends Activity {

    public static final String EXTRA_RES_ID = "POS";

    //Images extracted from: https://github.com/pattle/simpsons-in-css
    private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1,
                    R.drawable.image2,
                    R.drawable.image3,
                    R.drawable.image4,
                    R.drawable.image5,
                    R.drawable.image6,
                    R.drawable.image7,
                    R.drawable.image8,
                    R.drawable.image9,
                    R.drawable.image10,
                    R.drawable.image11,
                    R.drawable.image12));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        gridview.setAdapter(new ImageAdapter(this, mThumbIdsFlowers));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);

                intent.putExtra(EXTRA_RES_ID, (int) id);

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
    }
}
