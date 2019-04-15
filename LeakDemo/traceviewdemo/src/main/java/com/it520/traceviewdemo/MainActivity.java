package com.it520.traceviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        String str = "";
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                str +=i;
                str +=j;
                Log.d(getClass().getSimpleName(), "click: " + str);
            }
        }
    }
}
