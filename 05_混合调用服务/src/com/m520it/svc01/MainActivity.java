package com.m520it.svc01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	private IMyService mBinder;
	private ServiceConnection mServiceConnection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startServiceClick(View v){
		Intent intent=new Intent(this,MyService.class);
		startService(intent);
	}
	
	public void bindServiceClick(View v) {
		Intent intent = new Intent(this, MyService.class);
		mServiceConnection = new ServiceConnection() {

			// 服务断开的时候调用的
			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.v("520it", "MyService onServiceDisconnected服务解绑");
			}

			// 服务绑定的时候调用的 当服务的onBind()返回一个对象的时候才被调用的
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.v("520it", "MyService onServiceConnected服务绑定");
				mBinder = (IMyService) service;
			}
		};
		bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
	}

	public void unbindServiceClick(View v) {
		unbindService(mServiceConnection);
	}

	public void stopServiceClick(View v) {
		Intent intent = new Intent(this, MyService.class);
		stopService(intent);
	}

}
