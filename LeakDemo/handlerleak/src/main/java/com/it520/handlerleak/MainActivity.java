package com.it520.handlerleak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static final int MESSAGE_SEND = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        startSendMessage();
    }

    private void startSendMessage() {
        MyHandler myHandler = new MyHandler(MainActivity.this);
        Message message = Message.obtain();
        message.what = MESSAGE_SEND;
        message.obj = "这是一段来自三体的消息";
        myHandler.sendMessageDelayed(message,20000);
//        myHandler.sendMessage(message);
    }


    //创建一个内部类handler
    //1 将内部类作为static的
    //2 把Handler写成一个独立的java文件

    private static class MyHandler extends Handler{

        private WeakReference<MainActivity> mWeakReference = null;

        MyHandler(MainActivity activity){
            mWeakReference = new WeakReference<MainActivity>(activity);
        }

        //处理发送过来的消息的
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity = mWeakReference.get();
            if(mainActivity==null){
                return;
            }
            //接收
            switch (msg.what) {
            		case MESSAGE_SEND:
                        String obj = (String) msg.obj;
                        Toast.makeText(mainActivity, obj, Toast.LENGTH_SHORT).show();
                        break;
            		}
        }
    }
}
