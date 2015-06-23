package com.possiblelabs.filemanagertest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InternalFileWriteReadActivity extends Activity {

	private final static String fileName = "TestFile.txt";
	private String TAG = "InternalFileWriteReadActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
		if (!getFileStreamPath(fileName).exists()) {

			try {

				writeFile();

			} catch (FileNotFoundException e) {
				Log.i(TAG, "FileNotFoundException");
			}
		}
		try {
			
			readFile(ll);

		} catch (IOException e) {
			Log.i(TAG, "IOException");
		}
	}

	private void writeFile() throws FileNotFoundException {

		FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);

		PrintWriter pw = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(fos)));

		pw.println("Line 1: This is a test of the File Writing API");
		pw.println("Line 2: This is a test of the File Writing API");
		pw.println("Line 3: This is a test of the File Writing API");

		pw.close();

	}

	private void readFile(LinearLayout ll) throws IOException {

		FileInputStream fis = openFileInput(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = "";

		while (null != (line = br.readLine())) {

			TextView tv = new TextView(this);
			tv.setTextSize(24);
			tv.setText(line);

			ll.addView(tv);

		}

		br.close();

	}

}