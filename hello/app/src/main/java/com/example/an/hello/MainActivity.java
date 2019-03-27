package com.example.an.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);

        Button btn2=(Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this, "点击事件2",  Toast.LENGTH_LONG).show();
            }
        });

        Button btn3=(Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new MyClickListener());
    }

    class MyClickListener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            Toast.makeText(MainActivity.this, "点击事件3",  Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View arg0) {
        //Toast 吐司
        //duration 就是弹出的时间
        Toast.makeText(this, "还真的点我?", Toast.LENGTH_LONG).show();
    }

    public void btn4Click(View arg0) {
        //Toast 吐司
        //duration 就是弹出的时间
        Toast.makeText(this, "还真的点我?",  Toast.LENGTH_LONG).show();
    }
}
