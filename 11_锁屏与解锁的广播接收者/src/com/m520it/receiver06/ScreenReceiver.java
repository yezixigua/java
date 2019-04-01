package com.m520it.receiver06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *	锁屏与解锁是频繁的操作 所以只能在当前页面注册该广播接收者
 */
public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_SCREEN_OFF)) {
			Log.v("520it", "锁屏");
		}else if (action.equals(Intent.ACTION_SCREEN_ON)) {
			Log.v("520it", "解锁");
		}
	}

}
