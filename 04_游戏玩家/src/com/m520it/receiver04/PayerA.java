package com.m520it.receiver04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PayerA extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// ��ȡ�㲥����
		Log.v("520it", "A�����Ļ�:"+getResultData());
		//A������  �޸Ĺ㲥����
		setResultData("���ִ�Ӫ  �ҿ��Ͳ���!");
	}

}
