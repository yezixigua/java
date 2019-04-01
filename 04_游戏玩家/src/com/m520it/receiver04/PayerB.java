package com.m520it.receiver04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PayerB extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "B听到的话:"+getResultData());
		//B可能内部人员   我不玩了   终止广播
		abortBroadcast();
	}

}
