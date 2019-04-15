package com.it520.leakdemo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean isDestroy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        startTask();
    }

    private void startTask() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                Log.d(getClass().getSimpleName(), "run: " + i);
                SystemClock.sleep(1000);
            }
        }
    }


    //内部类隐式的持有了外部类Activity的引用,所有内部类中任务没执行完,Activity的引用就不会被释放
    //内部类改成了静态的内部类之后,内部类将不会再隐式持有外部类的引用
//    public static class MyThread extends Thread{
//
//        //通过使用弱引用来拿到外部类Activity的非静态属性和方法
//        private WeakReference<MainActivity> mWeakReference = null;
//
//        MyThread(MainActivity activity){
//            mWeakReference = new WeakReference<MainActivity>(activity);
//        }
//
//        @Override
//        public void run() {
//            //写在run方法中的逻辑会在MyThread线程中后台执行
//            MainActivity mainActivity = mWeakReference.get();
//            //为了健壮性
//            if(mainActivity!=null){
//                    for (int i = 0; i < 20; i++) {
//                        if(!mainActivity.isDestroy){
//                            Log.d(getClass().getSimpleName(), "run: " + i);
//                            SystemClock.sleep(1000);
//                        }
//                    }
//            }
//
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
