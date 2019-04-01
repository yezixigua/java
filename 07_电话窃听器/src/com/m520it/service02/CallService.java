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
		// 开始时刻监听用户电话状态 休闲(没有电话) 铃响 接通 挂断
		// 如果自己写代码去监听用户的状态 肯定是很复杂的操作 求系统
		// 系统服务 电话有关的服务 sevice manager...作为后缀
		TelephonyManager manger = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// events 就是要指定对哪些事件比较关心
		manger.listen(new PhoneStateListener() {

			//incomingNumber 只有来电的时候才有值
			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				switch (state) {
					case TelephonyManager.CALL_STATE_IDLE:
						Log.v("520it", "休闲(没有电话)/挂断:"+incomingNumber);
						break;
					case TelephonyManager.CALL_STATE_OFFHOOK:
						Log.v("520it", " 接通 :"+incomingNumber);
						break;
					case TelephonyManager.CALL_STATE_RINGING:
						Log.v("520it", "铃响:"+incomingNumber);
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
