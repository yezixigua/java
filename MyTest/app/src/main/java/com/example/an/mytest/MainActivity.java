package com.example.an.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.button1:
                Log.i("zz","bt1点击事件");
                Toast.makeText(this, "zz1", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Log.i("zz","bt2点击事件");
                Toast.makeText(this, "zz2", Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                Log.i("zz","bt3点击事件");
                Toast.makeText(this, "zz3", Toast.LENGTH_LONG).show();
                break;
            case R.id.button4:
                Log.i("zz","bt4点击事件");
                Toast.makeText(this, "zz4", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }

}
