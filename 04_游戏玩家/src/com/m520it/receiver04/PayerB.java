package com.m520it.receiver04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PayerB extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "B�����Ļ�:"+getResultData());
		//B�����ڲ���Ա   �Ҳ�����   ��ֹ�㲥
		abortBroadcast();
	}

}
