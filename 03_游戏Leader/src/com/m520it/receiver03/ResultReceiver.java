package com.m520it.receiver03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ResultReceiver extends BroadcastReceiver{

	//���ܹ㲥�Ƿ���ֹ ResultReceiver���ܽ��յ���󴫵ݵ�����
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("520it", "��Ϸ�Ľ��:"+getResultData());
	}

}
