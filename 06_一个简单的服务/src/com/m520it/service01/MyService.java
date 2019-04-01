package com.m520it.service01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 *   1.创建一个服务 该服务继承Service
 */
public class MyService extends Service {

	@Override
	public void onCreate() {
		Log.v("520it", "MyService  onCreate");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onDestroy() {
		Log.v("520it", "MyService  onDestroy");
	}

}
