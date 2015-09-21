package com.possiblelabs.guishowcase;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by possiblelabs on 7/3/15.
 */
public class AlertDialogActivity extends Activity {

    private static final String TAG = "AlertDialogActivity";

    private Button btnShut;
    private DialogFragment dialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alertdialog_activity);
        btnShut = (Button) findViewById(R.id.btn_shut);
        btnShut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });
    }

    private void showAlert() {
        dialog = AlertDialogFragment.newInstance();
        dialog.show(getFragmentManager(), "Alert");
    }

    private void showProgress() {
        dialog = ProgressDialogFragment.newInstance();
        dialog.show(getFragmentManager(), "Shutdown");
    }

    private void continueShutdown(boolean shouldContinue) {
        if (shouldContinue) {
            btnShut.setEnabled(false);
            showProgress();
            finishShutdown();
        } else {
            dialog.dismiss();
        }
    }

    private void finishShutdown() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Log.i(TAG, e.toString());
                } finally {
                    finish();
                }
            }
        }).start();
    }

    public static class AlertDialogFragment extends DialogFragment {
        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }

        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Do you really want to exit?")
                    .setCancelable(false)
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    ((AlertDialogActivity) getActivity()).continueShutdown(false);
                                }
                            })
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, int id) {
                                    ((AlertDialogActivity) getActivity()).continueShutdown(true);
                                }
                            }).create();
        }
    }

    public static class ProgressDialogFragment extends DialogFragment {

        public static ProgressDialogFragment newInstance() {
            return new ProgressDialogFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final ProgressDialog dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Activity Shutting Down.");
            dialog.setIndeterminate(true);
            return dialog;
        }

    }
}
