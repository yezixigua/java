package com.m520it.svc01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.m520it.svc01.MyService.MyBinder;

public class MainActivity extends Activity {
	
	private MyBinder mBinder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void openService(View v){
		Intent intent=new Intent(this,MyService.class);
		
		bindService(intent, new ServiceConnection() {
			
			

			//服务断开的时候调用的
			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.v("520it", "MyService onServiceDisconnected服务解绑");
			}
			
			//服务绑定的时候调用的    当服务的onBind()返回一个对象的时候才被调用的
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.v("520it", "MyService onServiceConnected服务绑定");
				mBinder=(MyBinder) service;
			}
		}, BIND_AUTO_CREATE);
		
	}
	
	public void closeService(View v){
		Intent intent=new Intent(this,MyService.class);
		stopService(intent);
	}
	
	//如何与 Service进行交互
	public void connService(View v){
//		MyService service=new MyService();
//		service.showToast();
		mBinder.callShowToast();
	}


}
