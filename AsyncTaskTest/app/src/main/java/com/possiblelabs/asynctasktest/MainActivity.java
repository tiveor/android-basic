package com.possiblelabs.asynctasktest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnNoThread;
    private Button btnHilo;
    private Button btnAsyncTask;
    private Button btnAsyncDialog;
    private Button btnCancelar;

    private ProgressBar pbar;
    private ProgressDialog pDialog;

    private CustomAsyncTask task1;
    private CustomAsyncTaskDialog task2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNoThread = (Button) findViewById(R.id.btnNoThread);
        btnHilo = (Button) findViewById(R.id.btnHilo);
        btnAsyncTask = (Button) findViewById(R.id.btnAsyncTask);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnAsyncDialog = (Button) findViewById(R.id.btnAsyncDialog);
        pbar = (ProgressBar) findViewById(R.id.pbar);

        btnNoThread.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pbar.setMax(100);
                pbar.setProgress(0);
                for (int i = 1; i <= 10; i++) {
                    TaskUtil.sleep2s();
                    pbar.incrementProgressBy(10);
                }
                Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.task_finished), Toast.LENGTH_SHORT).show();
            }
        });

        btnHilo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        pbar.post(new Runnable() {
                            public void run() {
                                pbar.setProgress(0);
                            }
                        });

                        for (int i = 1; i <= 10; i++) {

                            TaskUtil.sleep2s();

                            pbar.post(new Runnable() {
                                public void run() {
                                    pbar.incrementProgressBy(10);
                                }
                            });
                        }

                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.task_finished), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });

        btnAsyncTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                task1 = new CustomAsyncTask(MainActivity.this, pbar);
                task1.execute();
            }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                task1.cancel(true);
            }
        });

        btnAsyncDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setMessage(MainActivity.this.getResources().getString(R.string.task_processing));
                pDialog.setCancelable(true);
                pDialog.setMax(100);

                task2 = new CustomAsyncTaskDialog(MainActivity.this, pDialog);
                task2.execute();
            }
        });
    }


}