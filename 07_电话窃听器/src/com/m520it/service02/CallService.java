package com.m520it.service02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		// ��ʼʱ�̼����û��绰״̬ ����(û�е绰) ���� ��ͨ �Ҷ�
		// ����Լ�д����ȥ�����û���״̬ �϶��Ǻܸ��ӵĲ��� ��ϵͳ
		// ϵͳ���� �绰�йصķ��� sevice manager...��Ϊ��׺
		TelephonyManager manger = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// events ����Ҫָ������Щ�¼��ȽϹ���
		manger.listen(new PhoneStateListener() {

			//incomingNumber ֻ�������ʱ�����ֵ
			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				switch (state) {
					case TelephonyManager.CALL_STATE_IDLE:
						Log.v("520it", "����(û�е绰)/�Ҷ�:"+incomingNumber);
						break;
					case TelephonyManager.CALL_STATE_OFFHOOK:
						Log.v("520it", " ��ͨ :"+incomingNumber);
						break;
					case TelephonyManager.CALL_STATE_RINGING:
						Log.v("520it", "����:"+incomingNumber);
						break;
				}

			}
		}, PhoneStateListener.LISTEN_CALL_STATE);

	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
