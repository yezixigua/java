package com.m520it.service03;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	@Override
	public void onCreate() {
		super.onCreate();
		//�������������ִ��һ��ѭ���Ĵ�ӡ ֤�����񻹻���
		//����һ����ʱ��   period����
		//һ��ʼ�ӳ�2�� ִ����TimerTask   �ӳ�3��TimerTask  �ӳ�3��TimerTask .....
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				Log.v("520it", "���Ƿ���  �һ����� ....");
			}
		} , 2000, 3000);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
