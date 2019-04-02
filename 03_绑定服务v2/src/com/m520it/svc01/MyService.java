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

	// 秘书 需要实现特定的业务的
	private class MyBinder extends Binder implements IMyService{

		@Override
		public void callShowToast() {
			showToast();
		}

		public void changK() {
			Log.v("520it", "于是跟秘书愉快的唱K了");
		}

	}
	
	//代理(经纪人)
	//又请了一个新的秘书
	private class MyNewBinder extends Binder implements IMyService{

		@Override
		public void callShowToast() {
			showToast();
		}
		
		public void sangna() {
			Log.v("520it", "于是跟秘书愉快的桑拿了");
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.v("520it", "MyService onBind");
		return new MyNewBinder();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v("520it", "MyService onDestroy");
	}

	public void showToast() {
		Toast.makeText(this, "服务里面的方法", Toast.LENGTH_SHORT).show();
	}

}
