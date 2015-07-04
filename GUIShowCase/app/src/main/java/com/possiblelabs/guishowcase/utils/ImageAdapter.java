package com.possiblelabs.guishowcase.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.possiblelabs.guishowcase.R;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class ImageAdapter extends FragmentStatePagerAdapter {

    // List of IDs corresponding to the images
    private Integer[] mImageIds = {R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8};

    public ImageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ImageHolderFragment();
        Bundle args = new Bundle();
        args.putInt(ImageHolderFragment.RES_ID, mImageIds[i]);
        args.putString(ImageHolderFragment.POS, String.valueOf(i));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

}