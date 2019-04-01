package com.m520it.service03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//1.现象:同样应用程序被关闭了  线程同时被杀死  如果是服务(先被杀死 然后重新启动)
		//2.本质:服务是一个安卓组件 (先被杀死 然后重新启动):
		//系统认为服务之所以被杀死 是因为当前应用的进程被杀死  可能是因为内存不足而造成 它会重新启动服务
		
		
		
	}
	
	public void openThread(View v){
		new Thread(){
			public void run() {
				while (true) {
					SystemClock.sleep(3000);
					Log.v("520it","我是线程  我还活着 ....");
				}
			}
		}.start();
	}
	
	public void openService(View v){
		Intent intent=new Intent(this,MyService.class);
		startService(intent);
	}

}
