package com.possiblelabs.asynctasktest;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by possiblelabs on 10/7/15.
 */
public class CustomAsyncTask extends GenericAsyncTask {

    private Context context;
    private ProgressBar pbar;

    public CustomAsyncTask(Context context, ProgressBar pbar) {
        this.context = context;
        this.pbar = pbar;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();
        if (pbar == null)
            return;

        pbar.setProgress(progreso);
    }

    @Override
    protected void onPreExecute() {
        if (pbar == null)
            return;

        pbar.setMax(100);
        pbar.setProgress(0);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result)
            Toast.makeText(context, "CustomAsyncTask executed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCancelled() {
        Toast.makeText(context, "CustomAsyncTask cancelled!", Toast.LENGTH_SHORT).show();
    }
}