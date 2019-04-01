package com.m520it.apkreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ApkStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
			Log.v("520it", "Ӧ�ñ���װ");
		}else if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
			Log.v("520it", "Ӧ�ñ�ж��");
		}
	}

}
