package com.m520it.receiver03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ResultReceiver extends BroadcastReceiver{

	//不管广播是否终止 ResultReceiver都能接收到最后传递的数据
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "游戏的结果:"+getResultData());
	}

}
