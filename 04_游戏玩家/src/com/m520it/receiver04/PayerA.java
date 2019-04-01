package com.m520it.receiver04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PayerA extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// 获取广播数据
		Log.v("520it", "A听到的话:"+getResultData());
		//A表达出错  修改广播数据
		setResultData("快乐大本营  我看就不行!");
	}

}
