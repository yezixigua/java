package com.m520it.receiver04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PayerC extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "CÌýµ½µÄ»°:"+getResultData());
	}

}
