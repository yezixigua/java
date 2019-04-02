package com.m520it.svc01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v("520it", "MyService onCreate服务创建的时候调用");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v("520it", "MyService onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.v("520it", "MyService onBind");
		return new MyNewBinder();
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.v("520it", "MyService onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v("520it", "MyService onDestroy");
	}
	
	private class MyNewBinder extends Binder implements IMyService{

		@Override
		public void callShowToast() {
			showToast();
		}

	}

	public void showToast() {
		Toast.makeText(this, "服务里面的方法", Toast.LENGTH_SHORT).show();
	}

}
