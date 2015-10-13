package com.possiblelabs.asynctasktest;

import android.os.AsyncTask;

/**
 * Created by possiblelabs on 10/7/15.
 */
public abstract class GenericAsyncTask extends AsyncTask<Void, Integer, Boolean> {


    protected void doSomething() {
        TaskUtil.sleep2s();
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        for (int i = 1; i <= 10; i++) {
            doSomething();

            publishProgress(i * 10);

            if (isCancelled())
                break;
        }

        return true;
    }
}
