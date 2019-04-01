package com.m520it.service03;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	@Override
	public void onCreate() {
		super.onCreate();
		//在这个方法里面执行一个循环的打印 证明服务还活着
		//设置一个定时器   period周期
		//一开始延迟2秒 执行了TimerTask   延迟3秒TimerTask  延迟3秒TimerTask .....
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				Log.v("520it", "我是服务  我还活着 ....");
			}
		} , 2000, 3000);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
