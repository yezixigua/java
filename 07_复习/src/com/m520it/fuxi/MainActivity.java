package com.m520it.fuxi;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Uri ͳһ��Դ��λ��(��Դ���ĸ��ط� Ӧ����һ���ַ�����������)  
//		ftp://  http://  rtsp://
//		fromFile(file) ��һ���ļ���Ϊ��Դ��λ
//		parse("http://dasda")  ��λһ��http��������Դ
		
//		Intent ���Դ���8��������� �����Դ��ݶ���
		Intent intent=new Intent();
//		Bundle���� ��װ��8���������  ����һ�� HashMap
//		intent.putExtras(Bundle);
		
		
	}


}
