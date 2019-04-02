package com.m520it.svc01;

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
	
	public void openService(View v){
		Intent intent=new Intent(this,MyService.class);
		startService(intent);
	}
	
	public void closeService(View v){
		Intent intent=new Intent(this,MyService.class);
		stopService(intent);
	}


}
