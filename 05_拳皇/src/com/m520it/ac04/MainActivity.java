package com.m520it.ac04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mLifeTv;
	private int life=100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("520it", "onCreate ���汻������ʱ����õ�");
		
		mLifeTv =(TextView) findViewById(R.id.life_tv);
		mLifeTv.setText(life+"");
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
		//ȡ���Է�������ֵ Ȼ��-10 ������ʾ
		life-=10;
		mLifeTv.setText(life+"");
	}


}
