package com.m520it.receiver05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("520it", "onCreate "+Thread.currentThread().getName());
	}
	
	public void sendBroadCastClick(View v){
		Intent intent=new Intent(this,MyReceiver.class);
		sendBroadcast(intent);
	}


}
