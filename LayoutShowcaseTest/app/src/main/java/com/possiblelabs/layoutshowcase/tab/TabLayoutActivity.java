package com.possiblelabs.layoutshowcase.tab;

//Copyright (c) 2015 Adam Porter
//Code extracted from: https://github.com/aporter/coursera-android

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.possiblelabs.layoutshowcase.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by possiblelabs on 6/30/15.
 */
public class TabLayoutActivity extends ActionBarActivity {

    private static final String ANIMALS_TABSTRING = "Animals";
    private static final String SIMPSONS_TABSTRING = "Simpsons";
    protected static final String THUMBNAIL_IDS = "thumbNailIDs";

    private ArrayList<Integer> mThumbIdsSimpsons = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8,
                    R.drawable.image9, R.drawable.image10, R.drawable.image11,
                    R.drawable.image12));

    private ArrayList<Integer> mThumbIdsAnimals = new ArrayList<Integer>(
            Arrays.asList(R.drawable.sample_1, R.drawable.sample_2,
                    R.drawable.sample_3, R.drawable.sample_4,
                    R.drawable.sample_5, R.drawable.sample_6,
                    R.drawable.sample_7, R.drawable.sample_0));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab);

        final ActionBar tabBar = getSupportActionBar();
        tabBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        GridFragment flowerFrag = new GridFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(THUMBNAIL_IDS, mThumbIdsSimpsons);
        flowerFrag.setArguments(args);
        tabBar.addTab(tabBar.newTab().setText(SIMPSONS_TABSTRING).setTabListener(new TabListener(flowerFrag)));

        GridFragment animalFrag = new GridFragment();
        args = new Bundle();
        args.putIntegerArrayList(THUMBNAIL_IDS, mThumbIdsAnimals);
        animalFrag.setArguments(args);
        tabBar.addTab(tabBar.newTab().setText(ANIMALS_TABSTRING).setTabListener(new TabListener(animalFrag)));

    }

    public static class TabListener implements ActionBar.TabListener {
        private static final String TAG = "TabListener";
        private final Fragment mFragment;

        public TabListener(Fragment fragment) {
            mFragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.i(TAG, "onTabSelected called");

            if (null != mFragment) {
                ft.replace(R.id.fragment_container, mFragment);
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.i(TAG, "onTabUnselected called");

            if (null != mFragment)
                ft.remove(mFragment);
        }

    }
}