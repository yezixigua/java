package com.m520it.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Intent ��ͼ(����Ҫ��ĳһ����)   3����� ��������ͨ��Intent��������  �����Դ�������
		//intent.setComponent(component)   ָ����ʾ�����Ľ���
		//intent.setClass(packageContext, cls)  ָ����ʾ�����Ľ���
		//intent.setAction(action)  ָ����ʽ�������� (ֻҪ�����������ܸ��ֻ������е�Ӧ�õ�ע���ļ��ڲ��Ľ���������ƥ��)
		//intent.addCategory(category)   ��ʽ������ʱ�򸽴���Action����Ϣ
		//Ҳ����ʽ������һ��
		//intent.setData(data)   ����һЩ���� ��Щ���ݸ�ϵͳ�й�ϵ  http://   smsto://   tel://
		//intent.setType(type)   һ�㲻���Լ��õ� ����MimeType
		//intent.setDataAndType(data, type)   ��������  �������ݵ���ʾ��ʽ  ��ʾԴ��  ��HTML�ĸ�ʽ����ʾ
		//intent.putExtra(name, value) �������ݵ�
		
	}
	
	public void myClick(View v){
//		Intent intent=new Intent(this,MyActivity.class);
		Intent intent=new Intent();
//		intent.setAction("��");
//		intent.addCategory("��");
//		intent.addCategory("����");
//		intent.setComponent(new ComponentName(this,MyActivity.class));
//		intent.setClass(this,MyActivity.class);
		
//		intent.setData(data)
		
		startActivity(intent);
	}


}
