package com.m520it.ac02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

//���ֲ�����
public class MainActivity extends Activity {
	
	private boolean ifPause;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("520it", "��ʼ��������");
	}
	
	//����ɼ���ʱ�򱻵��õ�
	@Override
	protected void onStart() {
		super.onStart();
		if (ifPause) {
			Log.v("520it", "�ӵ�ǰ��ͣ��λ�����²�������");
			ifPause=false;
		}
	}
	
	//���治�ɼ���ʱ�򱻵�����
	@Override
	protected void onStop() {
		super.onStop();
		Log.v("520it", "��ͣ�������� ��¼��ǰ���ŵĽ���");
		ifPause=true;
	}

}
