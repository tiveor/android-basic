package com.possiblelabs.asynctasktest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by possiblelabs on 10/7/15.
 */
public class CustomAsyncTaskDialog extends GenericAsyncTask {


    private Context context;
    private ProgressDialog pdialog;

    public CustomAsyncTaskDialog(Context context, ProgressDialog pdialog) {
        this.context = context;
        this.pdialog = pdialog;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();

        if (pdialog == null)
            return;

        pdialog.setProgress(progreso);
    }

    @Override
    protected void onPreExecute() {

        pdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                CustomAsyncTaskDialog.this.cancel(true);
            }
        });

        pdialog.setProgress(0);
        pdialog.show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            pdialog.dismiss();
            Toast.makeText(context, "CustomAsyncTaskDialog executed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCancelled() {
        Toast.makeText(context, "CustomAsyncTaskDialog cancelled!", Toast.LENGTH_SHORT).show();
    }

}
