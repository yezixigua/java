package com.m520it.smsreceiver;

import java.util.Iterator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//��ȡ��������ص�����
		Bundle bundle = intent.getExtras();
		//�����ڷ��͵Ĺ����� ���ܻ��ɶ���  �������������װ��һ������
		Object[] objs = (Object[]) bundle.get("pdus");
		for (Object obj : objs) {
			//�������ֻ���������2���Ƶ��ֽ�����д���
			byte[] buff=(byte[]) obj;
			//��������ת����һ������
			SmsMessage message=SmsMessage.createFromPdu(buff);
			//1.��ȡ������
			String phone = message.getDisplayOriginatingAddress();
			//2.���ŵ�����
			String smsContent = message.getDisplayMessageBody();
			
			Log.v("520it", phone+"  "+smsContent);
			
			//������Ϣ����ȥ...
		}
		//2.���߹㲥 ��Ҫ��������ȥ��   ��ֹ�㲥
		abortBroadcast();
	}

}
