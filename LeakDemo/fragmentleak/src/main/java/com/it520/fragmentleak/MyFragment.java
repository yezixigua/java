package com.it520.fragmentleak;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author 小码哥Android学院(520it.com)
 * @time 2016/10/22  11:31
 * @desc ${TODD}
 */
public class MyFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button button = new Button(container.getContext());
        button.setText("我是Fragment的TextView");
        button.setTextSize(50);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyThread myThread = new MyThread();
                myThread.start();
            }
        });
        return button;
    }

    //演示内存泄漏,来一个内部类Thread
    public class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                Log.d(getClass().getSimpleName(), "run: " + i);
                SystemClock.sleep(1000);
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //Fragment已经被销毁,如果这个时候调用LeakCanary的观察对象的watch方法,如果他发现还有引用,认为是内存泄露
        MyApplication.mRefWatcher.watch(MyFragment.this);
    }
}
