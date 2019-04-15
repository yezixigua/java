package com.it520.staticinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //一个静态的实例   静态的实例不会跟着外部类的关闭而销毁
    public static User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        user = new User();
    }

    //一个简单的非静态内部类,隐式持有外部类的引用
    private class User{
        User(){

        }
    }
}
