package com.m520it.ac03;

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
	}
	
	public void myClick(View v){
		//�����ť��ʱ������һ���µĽ���Activity
		//������ڰ���ȥ ��ô�µĽ���϶��Ḳ���ϵĽ��� �����Ͳ��ܿ����ϵĽ��� �ǾͲ�����ͣ
		//���:�ܲ��ܽ��µĽ�����͸���Ľ���
		Intent intent=new Intent(this,MyActivity.class);
		startActivity(intent);
	}
	
	//��ͣ��ʱ�����
	@Override
	protected void onPause() {
		super.onPause();
		Log.v("520it", "onPause");
	}
	
	//�ָ���ʱ����õ�
	@Override
	protected void onResume() {
		super.onResume();
		Log.v("520it", "onResume");
	}


}
