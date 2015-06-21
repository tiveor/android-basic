package com.possiblelabs.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity implements View.OnClickListener {

    private final static int BUTTONS_SIZE = 11;
    private Button[] btnNumbers;

    private TextView txtResult;
    private TextView txtOperation;
    private ImageButton btnPlus;
    private ImageButton btnEquals;
    private double op1 = -1;
    private boolean op1_set = false;
    private double op2 = -1;
    private int result = 0;
    private boolean plus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNumbers = new Button[BUTTONS_SIZE];
        txtResult = (TextView) findViewById(R.id.txt_result);
        txtOperation = (TextView) findViewById(R.id.txt_operation);
        btnPlus = (ImageButton) findViewById(R.id.btn_plus);
        btnEquals = (ImageButton) findViewById(R.id.btn_equals);

        btnNumbers[0] = (Button) findViewById(R.id.btn_0);
        btnNumbers[1] = (Button) findViewById(R.id.btn_1);
        btnNumbers[2] = (Button) findViewById(R.id.btn_2);
        btnNumbers[3] = (Button) findViewById(R.id.btn_3);
        btnNumbers[4] = (Button) findViewById(R.id.btn_4);
        btnNumbers[5] = (Button) findViewById(R.id.btn_5);
        btnNumbers[6] = (Button) findViewById(R.id.btn_6);
        btnNumbers[7] = (Button) findViewById(R.id.btn_7);
        btnNumbers[8] = (Button) findViewById(R.id.btn_8);
        btnNumbers[9] = (Button) findViewById(R.id.btn_9);
        btnNumbers[10] = (Button) findViewById(R.id.btn_dot);

        for (Button btn : btnNumbers) {
            btn.setOnClickListener(this);
        }

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus = true;
                txtOperation.setText("+");
                op1 = Double.parseDouble(txtResult.getText().toString());
                op1_set = true;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                op2 = op1 + Double.parseDouble(txtResult.getText().toString());
                txtResult.setText(op2 + "");
                txtOperation.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        Button pressed = (Button) view;
        for (Button btn : btnNumbers) {
            if (pressed == btn) {

                if (op1_set) {
                    txtResult.setText("");
                    op1_set = false;
                }

                String v = btn.getText().toString();
                txtResult.append(v);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
