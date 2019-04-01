package com.m520it.ac04;

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
		Log.v("520it", "onCreate ���汻������ʱ����õ�");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.v("520it", "onStart ����ɼ���ʱ����õ�");
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.v("520it", "onResume ����ɼ��� �����ܹ���ȡ����(�ܸ��û����н���)ʱ����õ�");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.v("520it", "onPause ����ɼ��� �����޷�����(�޷���ȡ����)ʱ����õ�");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.v("520it", "onStop ���治�ɼ���ʱ����õ�");
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("520it", "onDestroy ���汻���ٵ�ʱ����õ�");
	}
	
	public void myClick(View v){
		Intent intent=new Intent(this,MyActivity.class);
		startActivity(intent);
	}


}
