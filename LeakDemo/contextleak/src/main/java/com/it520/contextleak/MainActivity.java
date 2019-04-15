package com.it520.contextleak;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        //通过ToastManager来展示吐司
//        ToastManager instance = ToastManager.getInstance(getApplicationContext());
//        instance.showToast("演示Context内存泄漏");
//        Service
        //用的是Application的上下文
        new AlertDialog.Builder(MainActivity.this).setTitle("对话框标题")
                .setMessage("对话框的一些消息内容")
                .show();
    }
}
