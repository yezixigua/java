package com.m520it.sdcardreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SDcardReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
			Log.v("520it", "һ��SD����װ��״̬");
		}else if (action.equals(Intent.ACTION_MEDIA_UNMOUNTED)) {
			Log.v("520it", "һ����SD��ж�ص�״̬");
		}
	}

}
