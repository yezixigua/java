package com.m520it.service02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent serviceIntent=new Intent(context,CallService.class);
		context.startService(serviceIntent);
	}

}
