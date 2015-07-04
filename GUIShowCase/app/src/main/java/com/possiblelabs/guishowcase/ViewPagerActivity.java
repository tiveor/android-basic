package com.possiblelabs.guishowcase;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.possiblelabs.guishowcase.utils.ImageAdapter;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class ViewPagerActivity extends ActionBarActivity {

    private ImageAdapter mImageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_activity);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mImageAdapter = new ImageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mImageAdapter);

    }
}
