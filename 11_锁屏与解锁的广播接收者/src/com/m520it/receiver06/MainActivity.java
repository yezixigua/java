package com.m520it.receiver06;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends Activity {

	private ScreenReceiver mReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//	 <receiver android:name="com.m520it.receiver06.ScreenReceiver">
//        <intent-filter>
//            <!-- ËøÆÁÓë½âËø -->
//            <action android:name="android.intent.action.SCREEN_OFF"/>
//            <action android:name="android.intent.action.SCREEN_ON"/>
//        </intent-filter>
//    </receiver>
		
		mReceiver=new ScreenReceiver();
		IntentFilter intentFilter=new IntentFilter();
		intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
		intentFilter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(mReceiver, intentFilter);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mReceiver);
	}


}
