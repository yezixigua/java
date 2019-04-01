package com.m520it.receiver03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	public void sendBroadCastClick(View v){
		Intent intent=new Intent();
		intent.setAction("com.m520it.receiver03.action.PASSVALUE");
//		receiverPermission   String  设置查看广播的权限
//		resultReceiver   结果广播接收者 不需要再配置中注册
//		scheduler   Handler 一般没用
//		initialCode   初始化编码   区别你的广播
//		initialData   String  广播名
//		initialExtras  Bundle  传递各种数据
		sendOrderedBroadcast(intent, 
				null,
				new ResultReceiver(),
				null, 
				0, 
				"快乐大本营 你看行不行?!", 
				null);
		
	}

}
