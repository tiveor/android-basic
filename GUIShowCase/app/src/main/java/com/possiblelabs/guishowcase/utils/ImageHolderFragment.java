package com.possiblelabs.guishowcase.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.possiblelabs.guishowcase.R;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class ImageHolderFragment extends Fragment {

    public static final String RES_ID = "res_id";
    public static final String POS = "position";

    private String mPos;
    private int mID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final Bundle args = getArguments();
        mPos = args.getString(POS);
        mID = args.getInt(RES_ID);

        ImageView imageView = (ImageView) inflater.inflate(R.layout.page, container, false);

        imageView.setImageResource(mID);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), mPos, Toast.LENGTH_SHORT).show();
            }
        });

        return imageView;
    }
}
