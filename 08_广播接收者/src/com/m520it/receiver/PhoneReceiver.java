package com.m520it.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *	1.������һ̨������
 */
public class PhoneReceiver extends BroadcastReceiver {

	//4.������Ŀ
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it","PhoneReceiver  onReceive");
	}

}
