package com.m520it.service03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//1.����:ͬ��Ӧ�ó��򱻹ر���  �߳�ͬʱ��ɱ��  ����Ƿ���(�ȱ�ɱ�� Ȼ����������)
		//2.����:������һ����׿��� (�ȱ�ɱ�� Ȼ����������):
		//ϵͳ��Ϊ����֮���Ա�ɱ�� ����Ϊ��ǰӦ�õĽ��̱�ɱ��  ��������Ϊ�ڴ治������ ����������������
		
		
		
	}
	
	public void openThread(View v){
		new Thread(){
			public void run() {
				while (true) {
					SystemClock.sleep(3000);
					Log.v("520it","�����߳�  �һ����� ....");
				}
			}
		}.start();
	}
	
	public void openService(View v){
		Intent intent=new Intent(this,MyService.class);
		startService(intent);
	}

}
