package com.m520it.receiver05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "onReceive "+Thread.currentThread().getName());
		//执行一个耗时操作  看有什么诡异的现象
		//SystemClock.sleep(10*1000);
		//在广播接收者中执行耗时操作 应该创建一个子线程
	}

}
