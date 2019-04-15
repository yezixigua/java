package com.it520.contextleak;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author 小码哥Android学院(520it.com)
 * @time 2016/10/22  9:31
 * @desc ${TODD}
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //检测内存泄漏的LeakCanary的初始化
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
