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
//		1.ʱʱ�̵̿ļ����û���ǰ�Ĵ�绰״̬--->Service
//		2.���û���ʼ�����绰��ʱ�� ��ʼ¼��   �û��Ҷ��˵绰 ֹͣ¼��---->¼�� 
//		3.����������״̬(�㲥 �ж�����)�ǿ��ŵ�ʱ��  ��Ӧ�÷���¼������̨������
		Intent intent=new Intent(this,CallService.class);
		startService(intent);
		finish();
	}
	
	public void myClick(View v){
		
	}


}
