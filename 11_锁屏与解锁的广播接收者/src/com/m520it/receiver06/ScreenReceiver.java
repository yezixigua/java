package com.m520it.receiver06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *	�����������Ƶ���Ĳ��� ����ֻ���ڵ�ǰҳ��ע��ù㲥������
 */
public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Intent.ACTION_SCREEN_OFF)) {
			Log.v("520it", "����");
		}else if (action.equals(Intent.ACTION_SCREEN_ON)) {
			Log.v("520it", "����");
		}
	}

}
