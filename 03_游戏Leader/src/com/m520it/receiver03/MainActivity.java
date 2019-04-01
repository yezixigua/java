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
//		receiverPermission   String  ���ò鿴�㲥��Ȩ��
//		resultReceiver   ����㲥������ ����Ҫ��������ע��
//		scheduler   Handler һ��û��
//		initialCode   ��ʼ������   ������Ĺ㲥
//		initialData   String  �㲥��
//		initialExtras  Bundle  ���ݸ�������
		sendOrderedBroadcast(intent, 
				null,
				new ResultReceiver(),
				null, 
				0, 
				"���ִ�Ӫ �㿴�в���?!", 
				null);
		
	}

}
