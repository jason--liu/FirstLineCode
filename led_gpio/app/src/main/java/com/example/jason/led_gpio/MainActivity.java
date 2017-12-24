package com.example.jason.led_gpio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private boolean ledOn = false;
    private Button button;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        checkBox1 = (CheckBox) findViewById(R.id.led1);
        checkBox2 = (CheckBox) findViewById(R.id.led2);
        checkBox3 = (CheckBox) findViewById(R.id.led3);
        led_ctrl.ledOpen();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ledOn = ! ledOn;

                if (ledOn){
                    button.setText("ALL OFF");
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    for(int i = 0; i< 3; i++) {
                        led_ctrl.ledCtrl(i, 1);
                    }

                } else {
                    button.setText("ALL ON");
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    for(int i = 0; i< 3; i++) {
                        led_ctrl.ledCtrl(i, 0);
                    }
                }
            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox1.isChecked())
                    led_ctrl.ledCtrl(0, 1);
                else
                    led_ctrl.ledCtrl(0, 0);
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox2.isChecked())
                    led_ctrl.ledCtrl(1, 1);
                else
                    led_ctrl.ledCtrl(1, 0);
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox3.isChecked())
                    led_ctrl.ledCtrl(2, 1);
                else
                    led_ctrl.ledCtrl(2, 0);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        led_ctrl.ledClose();
    }
}
