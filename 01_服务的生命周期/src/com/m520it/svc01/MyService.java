package com.m520it.svc01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.v("520it", "MyService onCreate在服务创建的时候调用");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v("520it", "MyService onStartCommand在服务开启的时候调用");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v("520it", "MyService onDestroy在服务销毁的时候调用");
	}

}
