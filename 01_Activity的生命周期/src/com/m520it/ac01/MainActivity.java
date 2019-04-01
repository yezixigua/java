package com.m520it.ac01;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText mContentEt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("520it", "onCreate");
		mContentEt =(EditText) findViewById(R.id.content_et);
		
		//�����½�������ʱ��Ӧ�ý����ݽ��л���
		SharedPreferences sp = getSharedPreferences("sms", MODE_PRIVATE);
		String content = sp.getString("content", "");
		mContentEt.setText(content);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("520it", "onDestroy");
		//�ڸ÷������汣����ŵ�����
		String content = mContentEt.getText().toString();
		
		SharedPreferences sp = getSharedPreferences("sms", MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("content", content);
		editor.commit();
	}


}
