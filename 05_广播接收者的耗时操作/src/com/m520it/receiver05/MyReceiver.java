package com.m520it.receiver05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "onReceive "+Thread.currentThread().getName());
		//ִ��һ����ʱ����  ����ʲô���������
		//SystemClock.sleep(10*1000);
		//�ڹ㲥��������ִ�к�ʱ���� Ӧ�ô���һ�����߳�
	}

}
